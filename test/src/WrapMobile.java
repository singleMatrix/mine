import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author single
 * @date 2018/3/10.
 */
public class WrapMobile {
  /*  public static void main(String[] args) {
        String path = "";
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/liyajun/Desktop/smsnoresume58.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/liyajun/Desktop/smsnoresume58param.txt"))) {

            Set<Long> moths = WrapMobile.getMothUid();

            while(true){
                String line = reader.readLine();
                if(line == null || line.equals("")){
                    break;
                }
                String[] lines = line.split("\\|");
                if(!moths.contains(Long.parseLong(lines[0]))){
                    writer.write(line + "\r\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private static Set<Long> getMothUid() {
        File dir = new File("/Users/liyajun/Desktop/filter");

        Set<Long> uids = new HashSet<>();
        File[] files = dir.listFiles();
        for (File file : files) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        uids.add(Long.parseLong(line));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return uids;
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("wrap mobile");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/liyajun/Desktop/20180321wbuidmobile.txt"));

            File directory = new File("/Users/liyajun/Desktop/filter");
            if (!directory.isDirectory()) {
                System.out.println("is not a directory");
                return;
            }
            File[] files = directory.listFiles();
            if (files == null || files.length == 0) {
                System.out.println("no files");
                return;
            }

            int all = 0;
            for (int i = 0; i < files.length; i++) {
                int fileall = 0;
                File mobileFile = files[i];
                try {
                    FileReader reader = new FileReader(mobileFile);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    int empty = 0;
                    while (empty < 20) {
                        String line = bufferedReader.readLine();
                        try {
                            if (line == null || line.equals("") || line.trim().equals("")) {
                                empty++;
                                continue;
                            } else {
                                empty = 0;
                            }
                            String[] params = line.split("\t");
                            if (params.length <= 1) {
                                continue;
                            }
                            Long uid = Long.parseLong(params[0].trim());
                            Long mobile = Long.parseLong(params[1].trim());
                            bufferedWriter.write(uid + "|" + mobile +"\r\n");
                            all++;
                            fileall++;
                        } catch (Exception e) {
                            System.out.println(mobileFile.getAbsolutePath());
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(mobileFile.getAbsolutePath());
                }
                System.out.println("file:" + mobileFile.getPath() + ":" + fileall);
            }
            System.out.println(all);
            System.out.println("--------------------");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
