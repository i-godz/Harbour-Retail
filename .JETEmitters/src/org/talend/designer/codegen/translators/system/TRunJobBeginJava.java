package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import java.util.Map;
import java.util.List;
import java.util.Date;

public class TRunJobBeginJava
{
  protected static String nl;
  public static synchronized TRunJobBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobBeginJava result = new TRunJobBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class DealChildJobLibrary_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "\tpublic String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {" + NL + "\t\tString classPathLine = \"\";" + NL + "\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\tif (isNeedAddLibsPath( crcMapPath)) {" + NL + "\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\tjava.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {" + NL + "\t\t\t\t\tif(!\"java.util.HashMap\".equals(desc.getName())) {" + NL + "\t\t\t\t\t\tthrow new java.io.InvalidClassException(\"Unauthorized deserialization attempt : \" + desc.getName());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.resolveClass(desc);" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\tois.close();" + NL + "\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t} else {" + NL + "\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t}" + NL + "\t\treturn classPathLine;" + NL + "\t}" + NL + "\t" + NL + "\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\tString jarName = entry.getValue();" + NL + "\t\tString crc = entry.getKey();" + NL + "\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "}" + NL + "\tDealChildJobLibrary_";
  protected final String TEXT_3 = " dealChildJobLibrary_";
  protected final String TEXT_4 = " = new DealChildJobLibrary_";
  protected final String TEXT_5 = "();" + NL + "" + NL + "\tclass JVMArgumentHelper_";
  protected final String TEXT_6 = " {" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t" + NL + "\t\tprivate boolean have_set_custom_argument;" + NL + "\t\t" + NL + "\t\tprivate java.util.List<String> custom_arguments;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tboolean custom_file_encoding;" + NL + "\t\tboolean custom_jmxremote;" + NL + "\t\tboolean custom_jmxremote_port;" + NL + "\t\tboolean custom_jmxremote_ssl;" + NL + "\t\tboolean custom_jmxremote_authenticate;" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t" + NL + "\t\tprivate void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\tString extra_classpath = ";
  protected final String TEXT_11 = ";" + NL + "\t\t\tString path_separator = System.getProperty(\"path.separator\");" + NL + "\t\t\tif (path_separator != null && path_separator.length() > 1) {" + NL + "\t\t\t\tthrow new RuntimeException(\"path separator should be single character\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(extra_classpath!=null && !extra_classpath.isEmpty()) {" + NL + "\t\t\t\tif(extra_classpath.endsWith(path_separator)) {" + NL + "\t\t\t\t\ttarget_argument_list.add(extra_classpath+job_origin_classpath);" + NL + "\t\t\t\t} else if(extra_classpath.contains(path_separator)) {" + NL + "\t\t\t\t\ttarget_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));" + NL + "\t\t\t\t} else if(extra_classpath.endsWith(\":\")) {" + NL + "\t\t\t\t\ttarget_argument_list.add(extra_classpath.replace(\":\", path_separator)+job_origin_classpath);" + NL + "\t\t\t\t} else if(extra_classpath.endsWith(\";\")) {" + NL + "\t\t\t\t\ttarget_argument_list.add(extra_classpath.replace(\";\", path_separator)+job_origin_classpath);" + NL + "\t\t\t\t} else if(extra_classpath.contains(\":\")) {" + NL + "\t\t\t\t\ttarget_argument_list.add(concatStr(extra_classpath.replace(\":\", path_separator), path_separator, job_origin_classpath));" + NL + "\t\t\t\t} else if(extra_classpath.contains(\";\")) {" + NL + "\t\t\t\t\ttarget_argument_list.add(concatStr(extra_classpath.replace(\";\", path_separator), path_separator, job_origin_classpath));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttarget_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\ttarget_argument_list.add(job_origin_classpath);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tprivate String concatStr(String s1, String s2, String s3) {" + NL + "\t\t\tjava.lang.StringBuilder strB = new java.lang.StringBuilder();" + NL + "\t\t\tstrB.append(s1).append(s2).append(s3);" + NL + "\t\t\treturn strB.toString();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {" + NL + "\t\t\taddArgumentsTo(target_argument_list, argument_from_child, false);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {" + NL + "\t\t\tif(isCP) {" + NL + "\t\t\t\taddClasspath(target_argument_list, argument_from_child);" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\tif(!have_set_custom_argument) {" + NL + "\t\t\t\tcustom_arguments = new java.util.ArrayList<>();" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tcustom_arguments.add(";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t" + NL + "\t\t\t\tfor(String current_custom_argument : custom_arguments) {" + NL + "\t\t\t\t\tif(current_custom_argument == null || current_custom_argument.isEmpty()) {" + NL + "\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\ttarget_argument_list.add(current_custom_argument);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(current_custom_argument.startsWith(\"-Dfile.encoding=\")) {" + NL + "\t\t\t\t\t\tcustom_file_encoding = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(current_custom_argument.equals(\"-Dcom.sun.management.jmxremote\")) {" + NL + "\t\t\t\t\t\tcustom_jmxremote = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(current_custom_argument.startsWith(\"-Dcom.sun.management.jmxremote.port=\")) {" + NL + "\t\t\t\t\t\tcustom_jmxremote_port = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(current_custom_argument.startsWith(\"-Dcom.sun.management.jmxremote.ssl=\")) {" + NL + "\t\t\t\t\t\tcustom_jmxremote_ssl = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(current_custom_argument.startsWith(\"-Dcom.sun.management.jmxremote.authenticate=\")) {" + NL + "\t\t\t\t\t\tcustom_jmxremote_authenticate = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\thave_set_custom_argument = true;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child == null || argument_from_child.isEmpty()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child.startsWith(\"-Dfile.encoding=\") && custom_file_encoding) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child.equals(\"-Dcom.sun.management.jmxremote\") && custom_jmxremote) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child.startsWith(\"-Dcom.sun.management.jmxremote.port=\") && custom_jmxremote_port) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child.equals(\"-Dcom.sun.management.jmxremote.ssl=false\") && custom_jmxremote_ssl) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(argument_from_child.equals(\"-Dcom.sun.management.jmxremote.authenticate=false\") && custom_jmxremote_authenticate) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\tif(argument_from_child.startsWith(\"--context=\")) {" + NL + "\t\t\t\ttarget_argument_list.add(\"--context=\"+";
  protected final String TEXT_18 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttarget_argument_list.add(argument_from_child);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\ttarget_argument_list.add(argument_from_child);" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\tpublic void reset() {" + NL + "\t\t\thave_set_custom_argument = false;" + NL + "\t\t\tcustom_arguments.clear();" + NL + "\t\t\t" + NL + "\t\t\tcustom_file_encoding = false;" + NL + "\t\t\tcustom_jmxremote = false;" + NL + "\t\t\tcustom_jmxremote_port = false;" + NL + "\t\t\tcustom_jmxremote_ssl = false;" + NL + "\t\t\tcustom_jmxremote_authenticate = false;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t}" + NL + "\t" + NL + "\tJVMArgumentHelper_";
  protected final String TEXT_23 = " jvm_argument_helper_";
  protected final String TEXT_24 = " = new JVMArgumentHelper_";
  protected final String TEXT_25 = "();" + NL + "\t" + NL + "\tString audit_jar_path_";
  protected final String TEXT_26 = " = System.getProperty(\"classpath.extended\");" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\t//For different jobs, job name must be different, but classpath and JVM arguments are possbilely different" + NL + "\t\tjava.util.Map<String,List<String>> childJob_commandLine_Mapper_";
  protected final String TEXT_28 = " = new java.util.HashMap<String,List<String>>();" + NL + "\t\tjava.util.List<String> childJob_commandLine_";
  protected final String TEXT_29 = " = null;" + NL + "\t\tString classpathSeparator_";
  protected final String TEXT_30 = " = System.getProperty(\"path.separator\");" + NL + "\t\tif (classpathSeparator_";
  protected final String TEXT_31 = " != null && classpathSeparator_";
  protected final String TEXT_32 = ".length() > 1) {" + NL + "\t\t\tthrow new RuntimeException(\"path separator should be single character\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\tchildJob_commandLine_";
  protected final String TEXT_34 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\tchildJob_commandLine_";
  protected final String TEXT_36 = ".add(\"";
  protected final String TEXT_37 = "\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tfinal java.util.List<String> cc_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = " = childJob_commandLine_";
  protected final String TEXT_40 = ";" + NL + "\t\t\t\t\tif(enableLogStash){" + NL + "\t\t\t\t\t\tSystem.getProperties().stringPropertyNames().stream()" + NL + "\t\t\t\t\t\t\t.filter(it -> it.startsWith(\"audit.\"))" + NL + "\t\t\t\t\t\t\t.forEach(key -> cc_";
  protected final String TEXT_41 = ".add(\"-D\" + key + \"=\" + System.getProperty(key)));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tSystem.getProperties().stringPropertyNames().stream()" + NL + "\t\t\t\t\t\t.filter(it -> it.startsWith(\"runtime.lineage.\") || \"classpath.extended\".equals(it))" + NL + "\t\t\t\t\t\t.forEach(key -> cc_";
  protected final String TEXT_42 = ".add(\"-D\" + key + \"=\" + System.getProperty(key)));" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t    \t\tString classpath_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL + "\t\t\t\t    \t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t    \t\tif(audit_jar_path_";
  protected final String TEXT_47 = "!=null && !audit_jar_path_";
  protected final String TEXT_48 = ".isEmpty()) {" + NL + "\t\t\t\t      \t\t\tclasspath_";
  protected final String TEXT_49 = " += audit_jar_path_";
  protected final String TEXT_50 = ";" + NL + "\t\t\t\t      \t\t}" + NL + "\t\t\t\t      \t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t      \t\tjvm_argument_helper_";
  protected final String TEXT_52 = ".addArgumentsTo(childJob_commandLine_";
  protected final String TEXT_53 = ", dealChildJobLibrary_";
  protected final String TEXT_54 = ".replaceJarPathsFromCrcMap(classpath_";
  protected final String TEXT_55 = ").replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_56 = "), ";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\t    ";
  protected final String TEXT_58 = NL + "\t\t\t\t    \t\tjvm_argument_helper_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_61 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_62 = " = \"";
  protected final String TEXT_63 = "\";" + NL + "\t\t\t\t    \t\t";
  protected final String TEXT_64 = ", \"";
  protected final String TEXT_65 = "\".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_66 = NL + "\t\t\t\tjvm_argument_helper_";
  protected final String TEXT_67 = ".reset();" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\tchildJob_commandLine_Mapper_";
  protected final String TEXT_69 = ".put(\"";
  protected final String TEXT_70 = "\",childJob_commandLine_";
  protected final String TEXT_71 = ");\t" + NL + "\t\t\t";
  protected final String TEXT_72 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
boolean useIndependentProcess = "true".equals(ElementParameterParser.getValue(node, "__USE_INDEPENDENT_PROCESS__"));

String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = "";

if(useDynamicJob) {
	context = ElementParameterParser.getValue(node,"__CONTEXT_NAME__");
} else {
	context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
}

boolean useExtraClassPath = "true".equals(ElementParameterParser.getValue(node, "__USE_EXTRA_CLASSPATH__"));
String extraClassPath = ElementParameterParser.getValue(node,"__EXTRA_CLASSPATH__");
boolean useDynamicContext = "true".equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_CONTEXT__"));
String dynamicContext = ElementParameterParser.getValue(node,"__DYNAMIC_CONTEXT__");
			
String[] codeOptions = null;

String[] commandLine = new String[] {"<command>"};

String childJobName;
int jobNamePosition;
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(isLog4jEnabled){
	codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\"", "\"--log4jLevel=\"+ log4jLevel", "(\"--audit.enabled=\"+ enableLogStash)"};
} else {
	codeOptions = new String[] {"\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", "\"--father_node="+ cid + "\""};
}

boolean use_custom_jvm_setting = "true".equals(ElementParameterParser.getValue(node, "__USE_CUSTOM_JVM_SETTING__"));
List<Map<String, String>> jvm_arguments = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JVM_ARGUMENTS__");

if(useDynamicJob || useIndependentProcess){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		if(use_custom_jvm_setting) {
		
    stringBuffer.append(TEXT_7);
    
		//the parameters below is set by Talend(sure come from Talend as we add one ProcessorUtilities.getCommandLine method to ignore the one set by user)
		//for function purpose, not set by user.
		//if user set them in tables of tRunjob with "overwrite child job vm parametes", we will overwrite the one from Talend
		//if user don't set them in tables of tRunjob with "overwrite child job vm parametes", we will append them in the jvm command for Talend function
		
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
			if(!useExtraClassPath) {
				extraClassPath = null;
			}
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(extraClassPath);
    stringBuffer.append(TEXT_11);
    if(use_custom_jvm_setting) {
    stringBuffer.append(TEXT_12);
    
				for (Map<String, String> one : jvm_arguments) {
					String jvm_argument = one.get("ARGUMENT");
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(jvm_argument);
    stringBuffer.append(TEXT_14);
    
				}
				
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
			if(useDynamicContext) {
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dynamicContext);
    stringBuffer.append(TEXT_18);
    
			} else {
			
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
		if(use_custom_jvm_setting) {
		
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
}
try {
	if(useDynamicJob){
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	
		//issue 19108: The context text field waits for a context name without quotes. The component removes the first quote and the last quote if they exist.
		if(context.startsWith("\"")) {
			context=context.substring(1, context.length());
		}
		if(context.endsWith("\"")) {
			context=context.substring(0, context.length()-1);
		}

		if(process!=null && !process.equals("")){
			String[] childJobIds = process.split(";");
			for (int i=0;i<childJobIds.length;i++) {
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
				String oldInterpreter = ProcessorUtilities.getInterpreter();
		        String oldCodeLocation = ProcessorUtilities.getCodeLocation();
		        String oldLibraryPath = ProcessorUtilities.getLibraryPath();
		        boolean oldExportConfig = ProcessorUtilities.isExportConfig();
		        Date oldExportTimestamp = ProcessorUtilities.getExportTimestamp();
		        boolean isJobTest = ProcessorUtilities.isJobTest(node.getProcess().getId(),context,null);
				if(isJobTest&&ProcessorUtilities.isCIMode()) {
					 ProcessorUtilities.setExportConfig(false);
					 ProcessorUtilities.setDynamicJobAndCITest(true);
				}
				
				try {
			    	commandLine = ProcessorUtilities.getCommandLine("win32", false, true, childJobIds[i], context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, use_custom_jvm_setting, codeOptions);
			    
				    // remove the frontal 2 lines
				    if (commandLine.length > 0 && ProcessorUtilities.isExportConfig()){
						int tmpSize = commandLine.length - 2;
						String[] tmp = new String[tmpSize];
						System.arraycopy(commandLine, 2, tmp, 0, tmpSize);
						commandLine = tmp;
					}
				} finally {
					if(isJobTest&&ProcessorUtilities.isCIMode()) {
				    	ProcessorUtilities.setExportConfig(oldInterpreter, oldCodeLocation, oldLibraryPath, oldExportConfig,
                    oldExportTimestamp);
                        ProcessorUtilities.setDynamicJobAndCITest(false);
			    	}
			    }
			    
				boolean isCP = false;
				
				for (int j = 0; j < commandLine.length; j++) {
					// commandLine[j] = commandLine[j].replace("\n", "");
					if (j == 0){
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(commandLine[j]);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
				  } else if (j > 0){
				    if (commandLine[j].indexOf("\"") >= 0){
				    	if(commandLine[j].indexOf(".jar")>=0){
				    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_45);
    if(isCP && (commandLine[j].endsWith(":\"") || commandLine[j].endsWith(";\""))) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(isCP);
    stringBuffer.append(TEXT_57);
    
				    	}else{
				    
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
				    	}
				    	
				    	if("\"-cp\"".equals(commandLine[j]) || "\"-classpath\"".equals(commandLine[j])) {
			    			isCP = true;
			    		} else {
			    			isCP = false;
			    		}
				    }else{
				    	if(commandLine[j].indexOf(".jar")>=0){
				    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_63);
    if(isCP && (commandLine[j].endsWith(":") || commandLine[j].endsWith(";"))) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(j );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(isCP);
    stringBuffer.append(TEXT_57);
    
				    	}else{
				    
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
				    	}
				    	
				    	if("-cp".equals(commandLine[j]) || "-classpath".equals(commandLine[j])) {
			    			isCP = true;
			    		} else {
			    			isCP = false;
			    		}
				    }
				  }
				}
				
				if(use_custom_jvm_setting) {
				
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
				}
				
				//find the job name and classpath, the job name in front of codeOptions
			    int position = 0;
			    for(String tempCommandLine : commandLine){
			   		if(codeOptions[0].equals(tempCommandLine)){
			   			break;
			   		}
			   		position++;
			    }
			    jobNamePosition = position-1;
			    
                childJobName = commandLine[jobNamePosition];

			    childJobName = childJobName.substring(childJobName.lastIndexOf(".")+1);
				
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(childJobName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
			}
		}
	}
} catch (ProcessorException e) {
}	

    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
