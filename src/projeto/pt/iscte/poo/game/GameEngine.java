package projeto.pt.iscte.poo.game;

import projeto.objects.GameObject;
import projeto.pt.iscte.poo.gui.ImageGUI;
import projeto.pt.iscte.poo.observer.Observed;
import projeto.pt.iscte.poo.observer.Observer;
import projeto.pt.iscte.poo.utils.Direction;
import projeto.pt.iscte.poo.utils.Point2D;

import java.io.File;

import static projeto.objects.Bomb.EXPLOSION_RADIUS;
//import java.util.ArrayList;

public class GameEngine implements Observer {
	private int roomNum=0;
	private Room currentRoom;
	private int lastTickProcessed = 0;

	public GameEngine()  {
		//posso criar logo as salas todas ?
		// fica tudo sobreposto com o getInstance().update
		currentRoom = new Room(roomNum);
		ImageGUI.getInstance().update();
	}

	public void changeRoom(int newRoomIndex) {
		if (newRoomIndex >= 0 && newRoomIndex < numberOfRoomFiles()) {
			roomNum = newRoomIndex;
			new Room(roomNum);
		} else {
			throw new IllegalArgumentException("Índice de sala inválido!");
		}
	}

	public static int numberOfRoomFiles() {return new File("rooms").listFiles().length;}

	@Override
	public void update(Observed source) {
		//a funcao ja faz update sozinha entao nao podemos fazer loops aqui

		if (ImageGUI.getInstance().wasKeyPressed()) {
			int k = ImageGUI.getInstance().keyPressed();
			System.out.println("Keypressed " + k);
			if (Direction.isDirection(k)) {
				System.out.println("Direction! ");
				currentRoom.moveJumpMan(k);
			}
			if(k == 98 || k == 66) {
				currentRoom.getJumpMan().deployBomb();
			}
		}
		int t = ImageGUI.getInstance().getTicks();

		if(isEven(lastTickProcessed)) {
			currentRoom.moveKong();
		}

		while (lastTickProcessed < t) {
			processTick();
		}
		ImageGUI.getInstance().update();
		 // Testar coleta de chave
        currentRoom.catchKey();
        System.out.println("JumpMan tem a chave? " + currentRoom.getJumpMan());

        // Testar troca de porta
        currentRoom.trocarPorta();
        System.out.println("Porta aberta? " + currentRoom.isFinished());
	}

	private boolean gameFinished() {
		//if(manel.getposition() == portaAberta) || manelIsDead()) {
			//inserir logica
		//}
		return false;
	}

	private void processTick() {
		System.out.println("Tic Tac : " + lastTickProcessed);
		lastTickProcessed++;
	}


	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

//    public void explode() {
//        for (int i = -EXPLOSION_RADIUS; i <= EXPLOSION_RADIUS; i++) {
//            for (int j = -EXPLOSION_RADIUS; j <= EXPLOSION_RADIUS; j++) {
//                Point2D position = new Point2D(getPosition().getX() + i, getPosition().getY() + j);
//                if (position.equals(getPosition())) {
//                    GameObject gameObject = whatsThere(position); // ver o metodo e aplicar
//                    if (gameObject.isDestructible()) {
//                        ga*meObject.dispose();
//                    }
//                }
//            }
//        }
//	removeImage();
//}

}
