package September6th.Factory;

public class CabinAirFilter extends Filter{
    public static class Factory implements September6th.Factory.Factory<CabinAirFilter>{
        @Override
        public CabinAirFilter create(){
            return new CabinAirFilter();
        }
    }
}
