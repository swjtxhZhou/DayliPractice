package September6th.Factory;

public class OilFilter extends Filter{
    public static class Factory implements September6th.Factory.Factory<OilFilter>{
        @Override
        public OilFilter create(){
            return new OilFilter();
        }
    }
}
