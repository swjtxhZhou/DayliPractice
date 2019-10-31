package September6th.Factory;


public class FuelFilter extends Filter {
    public static class Factory implements September6th.Factory.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
