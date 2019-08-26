package August23th.part3;

/**
 * 在捕获一个异常后抛出另一个异常，并且希望把原始异常保存下来,这被称为异常链
 * 多有Throwable的子类在构造器中都可以接受一个cause对象作为参数，这个cause就用来表示原始异常，通过这样把原始异常传给新的异常
 * 使得即使在当前位置创建并抛出了新的异常，也能通过异常链追踪到异常最初发生的位置.
 * 只有三种基本的异常类提供了带有cause参数的构造器，Error、Exception、RuntimeException.
 * 要把其他类型的异常链接起来，应该使用initCause()方法而不是构造器。
 */
public class DynamicFields {
    private Object[][] fields;

    /**
     * 构造器初始化
     * @param initialSize
     */
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    /**
     * 打印方法
     * @return
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Object[] obj:fields){
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * 是否有这个元素
     * @param id
     * @return
     */
    private int hasField(String id){
        for(int i =0; i<fields.length;i++){
            if(id.equals(fields[i][0]))return i;
        }
        return -1;
    }

    /**
     * 获得元素位置
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    private int getFieldNumber(String id)throws NoSuchFieldException{
        int fieldNum = hasField(id);
        if(fieldNum==-1){
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    /**
     * 生成元素，添加数组
     * @param id
     * @return
     */
    private int makeField(String id){
        for(int i=0;i<fields.length;i++){
            if(fields[i][0] ==null){
                fields[i][0] = id;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length][2];
        for(int i=0;i< fields.length;i++){
            tmp[i] = fields[i];
        }
        for(int i=fields.length;i<tmp.length;i++){
            tmp[i] = new Object[]{null,null};
        }
        fields = tmp;
        return makeField(id);
    }

    /**
     * 获得指定数组
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    public Object getField(String id)throws NoSuchFieldException{
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id,Object value)throws DynamicFiledsException{
        if(value == null){
            /**
             * 试图为一个字段设置一个空值，将抛出一个DynamicFieldsException异常，
             * 它是通过initCause（）方法将NullPointExcepption对象插入而建立的
             */
            DynamicFiledsException dfe = new DynamicFiledsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if(fieldNumber == -1){
            fieldNumber = makeField(id);
        }
        Object result = null;
        try{
            result = getField(id);
        }catch (NoSuchFieldException e){
            /**
             * 异常从setField()方法里抛出，这种会被视为编程错误，
             * 所以就使用cause（）参数的构造器把NoSuchFieldException异常转换为RuntimeException
             */
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }
    public static void main(String[] args){
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try{
            df.setField("d","a value for d");
            df.setField("number",47);
            df.setField("number2",48);
            System.out.println(df);
            df.setField("d","a new value for d");
            df.setField("number3",11);
            System.out.println("df:"+df);
            System.out.println("df.getField(\"d\"):"+df.getField("d"));
            Object field = df.setField("d",null);
        }catch (NoSuchFieldException e){
            e.printStackTrace(System.out);
        }catch (DynamicFiledsException e){
            e.printStackTrace(System.out);
        }
    }

}
