package response;

public  class  ResponseFormer {
    private static StringBuilder builder = new StringBuilder();

    public static void appendLine(String line){
        builder.append(line).append("\n");
    }


    public static String flush (){
        String s = builder.toString();
        builder = new StringBuilder();
        return s;
    }

}