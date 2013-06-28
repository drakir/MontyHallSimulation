package se.rikard.montyhall;

public class Simulation {

    private int rounds;
    private int numberOfDoors;

    public Simulation(int rounds, int numberOfDoors) {
        this.rounds = rounds;
        this.numberOfDoors = numberOfDoors;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(100000, 3);
        simulation.run();
    }

    public void run() {
        Player player = new Player();
        Moderator moderator = new Moderator();
        ImmutableDoors doors = new ImmutableDoors(numberOfDoors);

        int numberOfWinsStay = simulatePlayerStay(player, doors);
        int numberOfWinsChangedDoors = simulatePlayerChangeDoor(player, moderator, doors);

        System.out.println(String.format("Chance of winning the car when not changing door is %f percent", calculateWinChance(numberOfWinsStay)));
        System.out.println(String.format("Chance of winning the car when changing door is %f percent", calculateWinChance(numberOfWinsChangedDoors)));
    }


    private int simulatePlayerStay(Player player, ImmutableDoors doors) {
        int numberOfWins = 0;
        for (int i = 0; i < rounds; i++) {
            doors = doors.shuffle();

            Door chosenDoor = player.pickDoor(doors);
            if (chosenDoor.equals(doors.theCarDoor())) {
                numberOfWins++;
            }
        }
        return numberOfWins;
    }

    private int simulatePlayerChangeDoor(Player player, Moderator moderator, ImmutableDoors doors) {
        int numberOfWins = 0;
        for (int i = 0; i < rounds; i++) {
            doors = doors.shuffle();

            Door pickedDoor = player.pickDoor(doors);
            Door goatDoor = moderator.openGoatDoor(doors, pickedDoor);

            Door chosenDoor = player.chooseOtherDoor(doors, pickedDoor, goatDoor);
            if (chosenDoor.equals(doors.theCarDoor())) {
                numberOfWins++;
            }
        }
        return numberOfWins;
    }

    private float calculateWinChance(float numberOfWinsChangedDoors) {
        return 100 * numberOfWinsChangedDoors / rounds;
    }

}
