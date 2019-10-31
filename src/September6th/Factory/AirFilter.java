package September6th.Factory;

public class AirFilter extends Filter{
    public static class Factory implements September6th.Factory.Factory<AirFilter>{
        @Override
        public AirFilter create(){
            return new AirFilter();
        }
    }
}
