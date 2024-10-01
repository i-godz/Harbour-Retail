package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileListBeginJava
{
  protected static String nl;
  public static synchronized TFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileListBeginJava result = new TFileListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + " " + NL + "  ";
  protected final String TEXT_22 = "  " + NL + "        Comparator<java.io.File> fileNameASC_";
  protected final String TEXT_23 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_24 = NL + "        Comparator<java.io.File> fileNameDESC_";
  protected final String TEXT_25 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else if (bO1IsFile && !bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_26 = NL + "        Comparator<java.io.File> lastModifiedASC_";
  protected final String TEXT_27 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (o1.lastModified() > o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_28 = NL + "        Comparator<java.io.File> lastModifiedDESC_";
  protected final String TEXT_29 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (o1.lastModified() < o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;            " + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_30 = NL + "        Comparator<java.io.File> filseSizeASC_";
  protected final String TEXT_31 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "                      " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();                " + NL + "       " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (size_1 > size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else{" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_32 = NL + "        Comparator<java.io.File> filseSizeDESC_";
  protected final String TEXT_33 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                " + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();" + NL + "              " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (size_1 < size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_34 = NL + "    \tString fileName_";
  protected final String TEXT_35 = " = file.getName();" + NL + "\t\tfor (final java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_36 = " : patternList_";
  protected final String TEXT_37 = ") {" + NL + "          \tif (fileNamePattern_";
  protected final String TEXT_38 = ".matcher(fileName_";
  protected final String TEXT_39 = ").matches()){";
  protected final String TEXT_40 = NL + "\t\t\t \t\tboolean isExclude_";
  protected final String TEXT_41 = " = false;" + NL + "\t\t\t        for(java.util.regex.Pattern pattern : excludefileNameEachPattern_";
  protected final String TEXT_42 = ") {" + NL + "\t\t\t        \tif(pattern.matcher(fileName_";
  protected final String TEXT_43 = ").matches()) {" + NL + "\t\t\t        \t\tisExclude_";
  protected final String TEXT_44 = " = true;" + NL + "\t\t\t        \t\tbreak;" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        if(!isExclude_";
  protected final String TEXT_45 = " && !filePath_";
  protected final String TEXT_46 = ".contains(file.getAbsolutePath())) {" + NL + "\t\t\t          list_";
  protected final String TEXT_47 = ".add(file);" + NL + "\t\t\t          filePath_";
  protected final String TEXT_48 = ".add(file.getAbsolutePath());" + NL + "\t\t\t        }";
  protected final String TEXT_49 = NL + "\t\t\t\t\tif(!filePath_";
  protected final String TEXT_50 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_51 = "   " + NL + "    " + NL + "  String directory_";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";" + NL + "  final java.util.List<String> maskList_";
  protected final String TEXT_54 = " = new java.util.ArrayList<String>();" + NL + "  final java.util.List<java.util.regex.Pattern> patternList_";
  protected final String TEXT_55 = " = new java.util.ArrayList<java.util.regex.Pattern>();";
  protected final String TEXT_56 = NL + "      maskList_";
  protected final String TEXT_57 = ".add(\"*\");";
  protected final String TEXT_58 = ".add(\".*\");";
  protected final String TEXT_59 = " " + NL + "    maskList_";
  protected final String TEXT_60 = ".add(";
  protected final String TEXT_61 = "  " + NL + "  for (final String filemask_";
  protected final String TEXT_62 = " : maskList_";
  protected final String TEXT_63 = ") {" + NL + "\tString filemask_compile_";
  protected final String TEXT_64 = " = filemask_";
  protected final String TEXT_65 = ";" + NL + "\t";
  protected final String TEXT_66 = NL + "\t\tfilemask_compile_";
  protected final String TEXT_67 = " = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_";
  protected final String TEXT_68 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t";
  protected final String TEXT_69 = NL + "\t\tjava.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_70 = " = java.util.regex.Pattern.compile(filemask_compile_";
  protected final String TEXT_71 = ", java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "\t";
  protected final String TEXT_72 = NL + "\tpatternList_";
  protected final String TEXT_73 = ".add(fileNamePattern_";
  protected final String TEXT_74 = ");" + NL + "  }" + NL + "  int NB_FILE";
  protected final String TEXT_75 = " = 0;" + NL + "" + NL + "  final boolean case_sensitive_";
  protected final String TEXT_76 = ";";
  protected final String TEXT_77 = "   " + NL + "      String excludefilemask_";
  protected final String TEXT_78 = ";" + NL + "\t  final List<java.util.regex.Pattern> excludefileNameEachPattern_";
  protected final String TEXT_79 = " = new java.util.ArrayList<java.util.regex.Pattern>();" + NL + "\t  if(excludefilemask_";
  protected final String TEXT_80 = "!=null && !\"\".equals(excludefilemask_";
  protected final String TEXT_81 = ")) {" + NL + "\t  \tfor(String excludefilemaskEach_";
  protected final String TEXT_82 = " : excludefilemask_";
  protected final String TEXT_83 = ".split(\",\")) {" + NL + "\t  \t ";
  protected final String TEXT_84 = NL + "\t  \t\texcludefilemaskEach_";
  protected final String TEXT_85 = " = org.apache.oro.text.GlobCompiler.globToPerl5(excludefilemaskEach_";
  protected final String TEXT_86 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t  \t ";
  protected final String TEXT_87 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_88 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_89 = ",java.util.regex.Pattern.CASE_INSENSITIVE));" + NL + "\t\t ";
  protected final String TEXT_90 = "));" + NL + "\t\t ";
  protected final String TEXT_91 = "\t  \t \t\t" + NL + "\t  \t}" + NL + "\t  }";
  protected final String TEXT_92 = NL + "\t" + NL + "\t";
  protected final String TEXT_93 = NL + "\t\tlog.info(\"";
  protected final String TEXT_94 = " - Starting to search for matching entries.\");" + NL + "\t";
  protected final String TEXT_95 = NL + "\t" + NL + "    final java.util.List<java.io.File> list_";
  protected final String TEXT_96 = " = new java.util.ArrayList<java.io.File>();" + NL + "    final java.util.Set<String> filePath_";
  protected final String TEXT_97 = " = new java.util.HashSet<String>();" + NL + "\tjava.io.File file_";
  protected final String TEXT_98 = " = new java.io.File(directory_";
  protected final String TEXT_99 = ");" + NL + "    ";
  protected final String TEXT_100 = NL + "\t\tfile_";
  protected final String TEXT_101 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);" + NL + "\t\t\t\t";
  protected final String TEXT_102 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t                \treturn true;" + NL + "\t                } else {" + NL + "\t                  file.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_104 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t                  return true;" + NL + "\t                } else {" + NL + "\t                \t";
  protected final String TEXT_105 = NL + "\t                  \tfile.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t                 ";
  protected final String TEXT_107 = NL + "\t\t            if (file.isDirectory()) {" + NL + "\t\t              file.listFiles(this);" + NL + "\t\t            }" + NL + "\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t);";
  protected final String TEXT_109 = " " + NL + "\t\tfile_";
  protected final String TEXT_110 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);";
  protected final String TEXT_111 = NL + "                if (!file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_112 = NL + "                }";
  protected final String TEXT_113 = NL + "                if (file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_114 = NL + "                \t";
  protected final String TEXT_115 = NL + "              return true;" + NL + "            }" + NL + "          }" + NL + "      );";
  protected final String TEXT_116 = " ";
  protected final String TEXT_117 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_118 = ", fileName";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = ", filseSize";
  protected final String TEXT_121 = ", lastModified";
  protected final String TEXT_122 = NL + "    ";
  protected final String TEXT_123 = " - Start to list files.\");" + NL + "\t";
  protected final String TEXT_124 = NL + "    for (int i_";
  protected final String TEXT_125 = " = 0; i_";
  protected final String TEXT_126 = " < list_";
  protected final String TEXT_127 = ".size(); i_";
  protected final String TEXT_128 = "++){" + NL + "      java.io.File files_";
  protected final String TEXT_129 = " = list_";
  protected final String TEXT_130 = ".get(i_";
  protected final String TEXT_131 = ");" + NL + "      String fileName_";
  protected final String TEXT_132 = " = files_";
  protected final String TEXT_133 = ".getName();" + NL + "      " + NL + "      String currentFileName_";
  protected final String TEXT_134 = ".getName(); " + NL + "      String currentFilePath_";
  protected final String TEXT_135 = ".getAbsolutePath();" + NL + "      String currentFileDirectory_";
  protected final String TEXT_136 = ".getParent();" + NL + "      String currentFileExtension_";
  protected final String TEXT_137 = " = null;" + NL + "      " + NL + "      if (files_";
  protected final String TEXT_138 = ".getName().contains(\".\") && files_";
  protected final String TEXT_139 = ".isFile()){" + NL + "        currentFileExtension_";
  protected final String TEXT_140 = ".getName().substring(files_";
  protected final String TEXT_141 = ".getName().lastIndexOf(\".\") + 1);" + NL + "      } else{" + NL + "        currentFileExtension_";
  protected final String TEXT_142 = " = \"\";" + NL + "      }";
  protected final String TEXT_143 = NL + "        currentFilePath_";
  protected final String TEXT_144 = " = currentFilePath_";
  protected final String TEXT_145 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "        currentFileDirectory_";
  protected final String TEXT_146 = " = currentFileDirectory_";
  protected final String TEXT_147 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_148 = NL + "      " + NL + "      NB_FILE";
  protected final String TEXT_149 = " ++;" + NL + "      globalMap.put(\"";
  protected final String TEXT_150 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_151 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_152 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_153 = "_CURRENT_FILEDIRECTORY\", currentFileDirectory_";
  protected final String TEXT_154 = "_CURRENT_FILEEXTENSION\", currentFileExtension_";
  protected final String TEXT_155 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_156 = ");" + NL + "      ";
  protected final String TEXT_157 = " - Current file or directory path : \" + currentFilePath_";
  protected final String TEXT_158 = ");" + NL + "\t  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_21);
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
  boolean ifexclude = ("true").equals(ElementParameterParser.getValue(node, "__IFEXCLUDE__"));
  String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
  boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__GLOBEXPRESSIONS__"));
  List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
  boolean toSlash = ("true").equals(ElementParameterParser.getValue(node, "__FORMAT_FILEPATH_TO_SLASH__"));
  boolean caseSensitive = ("YES").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
  
  final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

  log4jFileUtil.componentStartInfo(node);
  class codeGenerater{
    public void genFileNameOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_23);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_24);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_25);
    
      }
    }
    
    public void genLastModifiedOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_26);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_27);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_28);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_29);
    
      }
    }
    
    public void genFileSizeOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_30);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_31);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_32);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_33);
    
      }
    }
    public void addFiles(String cid,boolean useGlob,boolean caseSensitive,boolean ifexclude){
    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    if (ifexclude){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }else{
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_50);
    
    }
  }  
  
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
  if (files.size() == 0){
    if (useGlob){
    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
    } else{
    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
    }
  }
  
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    if (useGlob){
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
	}
	if (caseSensitive){
	
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    }else{
    
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
 	}
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(caseSensitive );
    stringBuffer.append(TEXT_76);
    
    if (ifexclude){
    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node, "__EXCLUDEFILEMASK__"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    if (useGlob){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }
	  	 	if (!caseSensitive){
	  	 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
			} else {
		 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
			}
		 
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
    codeGenerater cg = new codeGenerater();
    if (incldSubdir) {
    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
				if (("FILES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_102);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_103);
    
				} else if(("DIRECTORIES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_104);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_105);
    
				} else if(("BOTH").equals(filelistType)) {
				
    stringBuffer.append(TEXT_106);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_107);
    
				}
				
    stringBuffer.append(TEXT_108);
    
    } else {
    
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
              if (("FILES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_111);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_112);
    
              } else if (("DIRECTORIES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_113);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_112);
    
              } else if (("BOTH").equals(filelistType)) {
              
    stringBuffer.append(TEXT_114);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    
              }
              
    stringBuffer.append(TEXT_115);
    
    }
    
    stringBuffer.append(TEXT_116);
    
    boolean bOrdByDefault = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_NOTHING__"));
    boolean bOrdByFileName = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILENAME__"));
    boolean bOrdByFileSize = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILESIZE__"));
    boolean bOrdByModifiedTime = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_MODIFIEDDATE__"));
    
    boolean bOrdASC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_ASC__"));
    //boolean bOrdDESC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_DESC__"));
    
    String suffix = bOrdASC ? "ASC" : "DESC";
    
    if (bOrdByDefault){
    
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
    } else if (bOrdByFileName){
      cg.genFileNameOder(cid, suffix);
      
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    } else if (bOrdByFileSize){
      cg.genFileSizeOder(cid, suffix);
      
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    } else if (bOrdByModifiedTime){
      cg.genLastModifiedOder(cid, suffix);
      
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
    }
    
    stringBuffer.append(TEXT_122);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    if (toSlash){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    return stringBuffer.toString();
  }
}
