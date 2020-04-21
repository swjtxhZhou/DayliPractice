package thinkingInJava.part1.part5_innerClasses;

public class Parcel6 {
    private String internalTracking(boolean b){
        String s=null;
        if(b){
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("hell");
            s= ts.getSlip();
            }
            return s;
        }
    public String track(){
        return internalTracking(true);
    }
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        System.out.println(p.track());
    }

}
