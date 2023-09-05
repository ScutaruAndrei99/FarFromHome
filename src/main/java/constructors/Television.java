package constructors;

public class Television {
    private int idTV;
    private int ChannelPost;
    private String ChannelName;
    private boolean Power;

    public Television(int idTV, int ChannelPost, String ChannelName, boolean Power) {
        this.idTV=3;
        this.ChannelPost=ChannelPost;
        this.ChannelName=ChannelName;
        this.Power=Power;
    }

    public boolean isPower() {
        return Power;
    }

    public void setPower(boolean power) {
        Power = power;
    }

    public int getChannelPost() {
        return ChannelPost;
    }

    public void setChannelPost(int channelPost) {
        ChannelPost = channelPost;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }
}
