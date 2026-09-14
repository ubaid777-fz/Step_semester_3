public class MovieBookingBean {
    private String name; private boolean confirmed; private String otp;
    public MovieBookingBean() { }
    public MovieBookingBean(String name) { this(); this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
    public void setOtp(String otp) { this.otp = otp; }
    public static void main(String[] args) { MovieBookingBean profile = new MovieBookingBean("Rahul Dev"); profile.setConfirmed(true); profile.setOtp("4471"); System.out.println(profile.getName()); System.out.println(profile.isConfirmed()); }
}