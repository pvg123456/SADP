class Amplifier {
    public void on() {
        System.out.println("Amplifier is ON");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level);
    }

    public void off() {
        System.out.println("Amplifier is OFF");
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("DVD Player is playing \"" + movie + "\"");
    }

    public void stop() {
        System.out.println("DVD Player has stopped playing");
    }

    public void eject() {
        System.out.println("DVD disc ejected");
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void wideScreenMode() {
        System.out.println("Projector is set to widescreen mode");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }
}

class TheaterLights {
    public void dim(int level) {
        System.out.println("Theater lights dimmed to " + level + "%");
    }

    public void on() {
        System.out.println("Theater lights are ON");
    }
}

class Screen {
    public void down() {
        System.out.println("Screen is DOWN");
    }

    public void up() {
        System.out.println("Screen is UP");
    }
}

class PopcornPopper {
    public void on() {
        System.out.println("Popcorn Popper is ON");
    }

    public void pop() {
        System.out.println("Popcorn Popper is popping popcorn!");
    }

    public void off() {
        System.out.println("Popcorn Popper is OFF");
    }
}


class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, TheaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }
}


public class Slip_15 {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights, screen, popper);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
