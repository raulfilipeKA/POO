package projeto.objects;

import projeto.pt.iscte.poo.utils.Point2D;

public abstract class Door extends GameObject {
    private String config;
    private int nextRoom;
    private String nextFileRoom;
    private boolean lastRoom = false;

    public Door(Point2D position) {
        super(position);
    }

    public void teleport(GameObject object, Point2D position) {
        //if(object.)
        object.setPosition(position);
    }

    public boolean canTeleport() {return true;}

    public void setRoomDets(String config) {
        if(!config.startsWith("#")){throw new IllegalArgumentException("Invalid config");}
        if(config.equals("#")) {
            setIsLastRoom(true);
        } else {
            config = config.substring(1);
            String[] parts = config.split(";");
            if(!parts[1].startsWith("room")){throw new IllegalArgumentException("Invalid file name");}
            nextFileRoom = parts[1];
            nextRoom = Integer.parseInt(parts[1].substring(parts[1].length()-5, parts[1].length() - 4));
        }

    }

    @Override
    public boolean isDestroyable() {return false;}

    public void setIsLastRoom(boolean lastRoom) {this.lastRoom = lastRoom;}
    public boolean isLastRoom() {return lastRoom;}
    public int getNextRoom() {return nextRoom;}
    public String getNextFileRoom() {return nextFileRoom;}

//    public static void main(String[] args) {
//        String config = "#0;room1.txt";
//        String[] parts = config.split(";");
//        System.out.println(parts[0]);
//        System.out.println(parts[1]);
//
//        Door door = new DoorClosed(new Point2D(0, 0));
//        door.setRoomDets("#");
//        System.out.println(door.isLastRoom());
//        Door door1 = new DoorClosed(new Point2D(0, 0));
//        door1.setRoomDets(config);
//        System.out.println(door1.isLastRoom());
//        System.out.println(door1.getNextRoom());
//        System.out.println(door1.getNextFileRoom());
//    }

}
