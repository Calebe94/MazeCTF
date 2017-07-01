

public class ImportWorld{
    try{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null)
            builder.append(line + "\n");
            br.close();
    }catch(IOException e){
        e.printStackTrace();
    }
    return builder.toString();

}
