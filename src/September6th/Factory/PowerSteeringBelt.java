package September6th.Factory;

public class PowerSteeringBelt extends Belt{
    public static class Factory implements September6th.Factory.Factory<PowerSteeringBelt>{
        @Override
        public PowerSteeringBelt create(){
            return new PowerSteeringBelt();
        }
    }
}
