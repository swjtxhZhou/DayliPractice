package September6th.Factory;

public class FanBelt extends Belt{
    public static class Factory implements September6th.Factory.Factory<FanBelt>{
        @Override
        public FanBelt create(){
            return new FanBelt();
        }
    }
}
