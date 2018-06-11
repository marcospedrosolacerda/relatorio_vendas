package pkg_relatorio_vendas;
import java.io.*;
public class SearchFiles implements FilenameFilter {

		private String ext;

		public SearchFiles(String ext) {
			this.ext = ext;
		}
		
		@Override
		public boolean accept(File loc, String name) {
			if(name.lastIndexOf('.')>0)
            {
               // get last index for '.' 
               int lastIndex = name.lastIndexOf('.');
               
               // get extension
               String str = name.substring(lastIndex);
               
               // matching extension 
               if(str.equalsIgnoreCase(ext))
               {
                  return true;
               }
            }
            return false;
			
		}
	}