package September6th.Factory;

public class GeneratorBelt extends Belt{
    public static class Factory implements September6th.Factory.Factory<GeneratorBelt>{
        @Override
        public GeneratorBelt create(){
            return new GeneratorBelt();
        }
    }
}
