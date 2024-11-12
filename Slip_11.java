
interface HeartModel {
    void showHeartStatus();  
}

interface BeatModel {
    void showHeartbeat(); 
}

class Heart implements HeartModel {
    @Override
    public void showHeartStatus() {
        System.out.println("Heart is beating... status: Healthy");
    }
}

class HeartToBeatAdapter implements BeatModel {
    private HeartModel heartModel;

    public HeartToBeatAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void showHeartbeat() {
        heartModel.showHeartStatus();
    }
}

public class Slip_11 {
    public static void main(String[] args) {

        HeartModel heart = new Heart();

        BeatModel beatModel = new HeartToBeatAdapter(heart);

        System.out.println("Using Beat Model:");
        beatModel.showHeartbeat(); 
    }
}
