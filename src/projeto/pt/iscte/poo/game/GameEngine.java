package projeto.pt.iscte.poo.game;

import projeto.objects.GoodMeat;
import projeto.objects.JumpMan;
import projeto.objects.Princess;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.Observed;
import projeto.pt.iscte.poo.observer.Observer;
import projeto.pt.iscte.poo.utils.Direction;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameEngine implements Observer {
	public static final String LEADERBOARD_FILE = "leaderBoard.txt";
	private int roomNum = 0;
	private Room currentRoom;
	private int lastTickProcessed = 0;
	private int ticksProcessedInCurrentRoom = 0;
	private boolean gameIsFinished = false;
	private ArrayList<Integer> leaderBoard = new ArrayList<>();

	public GameEngine() {
		currentRoom = new Room();
		ImageGUI.getInstance().update();
	}


	public void changeRoom(int newRoomIndex) {
		if (newRoomIndex >= 0 && newRoomIndex < numberOfRoomFiles()) {
			System.out.println(currentRoom.getJumpMan().getAttack());
			JumpMan jumpMan = currentRoom.getJumpMan();
			currentRoom.deleteRoom();
			roomNum = newRoomIndex;
			currentRoom = new Room(roomNum, jumpMan);
			System.out.println(currentRoom.getJumpMan().getAttack());
			//totalTicksProcessed+=lastTickProcessed;
			ticksProcessedInCurrentRoom = 0;
		} else {
			throw new IllegalArgumentException("Índice de sala inválido!");
		}
	}

	public static int numberOfRoomFiles() {
		return new File("rooms").listFiles().length;
	}

	@Override
	public void update(Observed source) {
		//a funcao ja faz update sozinha entao nao podemos fazer loops aqui

		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				System.out.println("Direction! ");
				currentRoom.moveJumpMan(k);
				currentRoom.checkTrap();
			}
			if (k == 98 || k == 66) {
				currentRoom.deployBomb(lastTickProcessed);
				//currentRoom.getJumpMan().deployBomb(lastTickProcessed);
			}

		} else if (currentRoom!=null) {
			currentRoom.applyGravity();
		}

		int t = ImageGUI.getInstance().getTicks();
		System.out.println("T: " + t);

		currentRoom.checkForDetonation(lastTickProcessed);

		if (isEven(lastTickProcessed)) {
			currentRoom.moveKong();
		}
		currentRoom.moveBat();
		currentRoom.moveThief();

		if (ticksProcessedInCurrentRoom == GoodMeat.TIME_TO_ROT && currentRoom.hasMeatToRot()) {
			currentRoom.rotMeat();
		}

		currentRoom.removeDeadCharacters();

		if (lastTickProcessed < t) {
			processTick();
		}

		if (isEven(lastTickProcessed)) {
			currentRoom.moveProjectile();
		}

//		while (lastTickProcessed < t) {processTick();} //o loop nao funciona bem ao alterar o valor dos ticks

		currentRoom.catchKey();
		System.out.println("JumpMan tem a chave? " + currentRoom.getJumpMan().hasKey());
		System.out.println("Porta precisa de chave? " + currentRoom.needsKey());

		if (currentRoom.atDoor() &&
				(currentRoom.getJumpMan().hasKey() || !currentRoom.needsKey())) {
			//currentRoom.trocarPorta1(); como change room é mais lento, ele executa esta acao tres vezes
			changeRoom(currentRoom.getDoor().getNextRoom());
			lastTickProcessed = 0;
			//ImageGUI.getInstance().update();

		}
		if (currentRoom.getJumpMan().getHealth() <= 0) {
			resetJumpMan(currentRoom.getJumpMan());
			System.out.println(currentRoom.getJumpMan().getLives());
		}
		if (currentRoom.getJumpMan().getLives() == 0) {
			resetGame();
		}

		ImageGUI.getInstance().update();

		if (isGameFinished()) {
			currentRoom.deleteRoom();
			currentRoom=null;
			System.out.println("Game is finished! Score: " + lastTickProcessed);
			System.out.println("Updating leaderboards...");
			updateLeaderboards(lastTickProcessed);
			System.out.println("Leaderboards updated!");
			printOnScreen();
			ImageGUI.getInstance().dispose(); // acho eu mas esta coisa funciona
			System.exit(0);
			return;
		}
	}

	private void processTick() {
		System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
		ticksProcessedInCurrentRoom++;
	}

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	public boolean isGameFinished() {
		if (roomNum == numberOfRoomFiles() - 1 && currentRoom.atDoor()
				&& (currentRoom.getJumpMan().hasKey() || !currentRoom.needsKey())
				|| roomNum == numberOfRoomFiles() - 1 &&
				(currentRoom.whatsThere(currentRoom.getJumpMan().getPosition(), Princess.class)) != null) {
			return true;
			//gameIsFinished = true;
		}
		return false;
		//return gameIsFinished;
	}

	public void resetJumpMan(JumpMan jumpMan) {
		jumpMan.loseLife();
		jumpMan.setPosition(currentRoom.getJumpManInitialPosition());
		jumpMan.setHealth(JumpMan.HEALTH);
	}

	public void resetGame() {
		currentRoom.deleteRoom();
		roomNum = 0;
		currentRoom = new Room();
		lastTickProcessed = 0;
		ticksProcessedInCurrentRoom = 0;
		gameIsFinished = false;
	}


	public void updateLeaderboards(int score) {
		try {
			Scanner sc = new Scanner(new File(LEADERBOARD_FILE));
			while (sc.hasNextInt()) {
				leaderBoard.add(sc.nextInt());
			}
			addToLeaderBoard(score);
			createFile();

		} catch (FileNotFoundException e) {
			leaderBoard.add(lastTickProcessed);
			createFile();
		}
	}

	public void printOnScreen() {
		String conteudo = "";
		try {
			File arquivo = new File(LEADERBOARD_FILE);
			Scanner scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				conteudo += linha + "\n";
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel label = new JLabel(conteudo);
		label.setForeground(Color.RED);
		JOptionPane.showMessageDialog(null, conteudo);
	}


	public void addToLeaderBoard(int score) {
		if (leaderBoard.size() < 10) {
			leaderBoard.add(score);
		} else {
			int worstTime = Collections.max(leaderBoard);
			if (score < worstTime) {
				leaderBoard.remove((Integer) worstTime);
				leaderBoard.add(score);
			}
		} //JOPTIONPANE para escrever no ecra

		Collections.sort(leaderBoard, Collections.reverseOrder());
	}

	//NOVO
	public void createFile() {
		try (PrintWriter fileWriter = new PrintWriter(LEADERBOARD_FILE)) {
			for (int time : leaderBoard) {
				fileWriter.println(time);
			}
		} catch (FileNotFoundException _) {
			System.err.println("Erro na criação do ficheiro");
		}
	}

}
