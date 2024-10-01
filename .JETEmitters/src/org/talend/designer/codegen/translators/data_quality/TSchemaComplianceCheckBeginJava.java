package org.talend.designer.codegen.translators.data_quality;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;

public class TSchemaComplianceCheckBeginJava
{
  protected static String nl;
  public static synchronized TSchemaComplianceCheckBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSchemaComplianceCheckBeginJava result = new TSchemaComplianceCheckBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    try {" + NL + "        if(";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null";
  protected final String TEXT_5 = NL + "        && (!\"\".equals(";
  protected final String TEXT_6 = "))";
  protected final String TEXT_7 = NL + "        true";
  protected final String TEXT_8 = NL + "        ) {";
  protected final String TEXT_9 = NL + "            if(!(\"true\".equals(";
  protected final String TEXT_10 = ") || \"false\".equals(";
  protected final String TEXT_11 = "))){" + NL + "                throw new java.lang.Exception(\"Wrong Boolean type!\");" + NL + "            }";
  protected final String TEXT_12 = NL + "            if(";
  protected final String TEXT_13 = ".toCharArray().length != 1){" + NL + "                throw new java.lang.Exception(\"Wrong Character type!\");" + NL + "            }";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = " tester_";
  protected final String TEXT_16 = " = new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ".valueOf(";
  protected final String TEXT_22 = NL + "        }" + NL + "    } catch(java.lang.Exception e) {" + NL + "globalMap.put(\"";
  protected final String TEXT_23 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 2;" + NL + "        errorMessageThrough += \"|wrong type\";" + NL + "    }";
  protected final String TEXT_24 = NL + "    if (";
  protected final String TEXT_25 = " != null){";
  protected final String TEXT_26 = NL + "        handleBigdecimalPrecision((";
  protected final String TEXT_27 = ").toPlainString(), ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = NL + "        handleBigdecimalPrecision(String.valueOf(";
  protected final String TEXT_30 = "), ";
  protected final String TEXT_31 = NL + "        ifPassedThrough = ifPassedThrough?ifPassed:false;" + NL + "        errorCodeThrough += errorCode;" + NL + "        errorMessageThrough += errorMessage;" + NL + "    }";
  protected final String TEXT_32 = NL + "    ";
  protected final String TEXT_33 = NL + "    && (!\"\".equals(";
  protected final String TEXT_34 = NL + "    true";
  protected final String TEXT_35 = NL + "    ) {";
  protected final String TEXT_36 = NL + "        if( ";
  protected final String TEXT_37 = ".length() > ";
  protected final String TEXT_38 = " )";
  protected final String TEXT_39 = ".substring(0, ";
  protected final String TEXT_40 = NL + "        tmpContentThrough = String.valueOf(";
  protected final String TEXT_41 = NL + "        tmpContentThrough = ";
  protected final String TEXT_42 = ".toString();";
  protected final String TEXT_43 = NL + "        if (tmpContentThrough.length() > ";
  protected final String TEXT_44 = ")";
  protected final String TEXT_45 = NL + "        if (";
  protected final String TEXT_46 = ") {" + NL + "            ifPassedThrough = false;" + NL + "            errorCodeThrough += 8;" + NL + "            errorMessageThrough += \"|exceed max length\";" + NL + "        }";
  protected final String TEXT_47 = NL + NL + "        if (tmpContentThrough.length() > ";
  protected final String TEXT_48 = NL + "    }";
  protected final String TEXT_49 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|Date format not defined\";";
  protected final String TEXT_50 = NL + "    try{" + NL + "        if (";
  protected final String TEXT_51 = NL + "        ){";
  protected final String TEXT_52 = NL + "                        if (!TalendDate.isDate((";
  protected final String TEXT_53 = ").toString(), ";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = "true";
  protected final String TEXT_56 = "false";
  protected final String TEXT_57 = "))" + NL + "                            throw new IllegalArgumentException(\"Data format not matches\");";
  protected final String TEXT_58 = NL + "                        FastDateParser.getInstance(";
  protected final String TEXT_59 = ", false).parse(";
  protected final String TEXT_60 = NL + "                        if(!TalendDate.isDateStrict((";
  protected final String TEXT_61 = NL + "        }" + NL + "    } catch(java.lang.Exception e){" + NL + "globalMap.put(\"";
  protected final String TEXT_62 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 2;" + NL + "        errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";" + NL + "    }";
  protected final String TEXT_63 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";";
  protected final String TEXT_64 = NL + "    ifPassedThrough = false;" + NL + "    errorCodeThrough += 2;" + NL + "    errorMessageThrough += \"|The TYPE of inputting data is error. (one of OBJECT, STRING, DATE)\";";
  protected final String TEXT_65 = NL + "    // validate nullable (empty as null)" + NL + "    if ((";
  protected final String TEXT_66 = " == null) || (\"\".equals(";
  protected final String TEXT_67 = "))) {";
  protected final String TEXT_68 = NL + "    // validate nullable" + NL + "    if (";
  protected final String TEXT_69 = " == null) {";
  protected final String TEXT_70 = NL + "        ifPassedThrough = false;" + NL + "        errorCodeThrough += 4;" + NL + "        errorMessageThrough += \"|empty or null\";" + NL + "    }";
  protected final String TEXT_71 = NL + "    class RowSetValueUtil_";
  protected final String TEXT_72 = " {" + NL + "" + NL + "        boolean ifPassedThrough = true;" + NL + "        int errorCodeThrough = 0;" + NL + "        String errorMessageThrough = \"\";" + NL + "        int resultErrorCodeThrough = 0;" + NL + "        String resultErrorMessageThrough = \"\";" + NL + "        String tmpContentThrough = null;" + NL + "" + NL + "        boolean ifPassed = true;" + NL + "        int errorCode = 0;" + NL + "        String errorMessage = \"\";" + NL + "" + NL + "        void handleBigdecimalPrecision(String data, int iPrecision, int maxLength){" + NL + "            //number of digits before the decimal point(ignoring frontend zeroes)" + NL + "            int len1 = 0;" + NL + "            int len2 = 0;" + NL + "            ifPassed = true;" + NL + "            errorCode = 0;" + NL + "            errorMessage = \"\";" + NL + "            if(data.startsWith(\"-\")){" + NL + "                data = data.substring(1);" + NL + "            }" + NL + "            data = org.apache.commons.lang.StringUtils.stripStart(data, \"0\");" + NL + "" + NL + "            if(data.indexOf(\".\") >= 0){" + NL + "                len1 = data.indexOf(\".\");" + NL + "                data = org.apache.commons.lang.StringUtils.stripEnd(data, \"0\");" + NL + "                len2 = data.length() - (len1 + 1);" + NL + "            }else{" + NL + "                len1 = data.length();" + NL + "            }" + NL + "" + NL + "            if (iPrecision < len2) {" + NL + "                ifPassed = false;" + NL + "                errorCode += 8;" + NL + "                errorMessage += \"|precision Non-matches\";" + NL + "            } else if (maxLength < len1 + iPrecision) {" + NL + "                ifPassed = false;" + NL + "                errorCode += 8;" + NL + "                errorMessage += \"|invalid Length setting is unsuitable for Precision\";" + NL + "            }" + NL + "        }" + NL + "" + NL + "        int handleErrorCode(int errorCode, int resultErrorCode){" + NL + "            if (errorCode > 0) {" + NL + "                if (resultErrorCode > 0) {" + NL + "                    resultErrorCode = 16;" + NL + "                } else {" + NL + "                    resultErrorCode = errorCode;" + NL + "                }" + NL + "            }" + NL + "            return resultErrorCode;" + NL + "        }" + NL + "" + NL + "        String handleErrorMessage(String errorMessage, String resultErrorMessage, String columnLabel){" + NL + "            if (errorMessage.length() > 0) {" + NL + "                if (resultErrorMessage.length() > 0) {" + NL + "                    resultErrorMessage += \";\"+ errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "                } else {" + NL + "                    resultErrorMessage = errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "                }" + NL + "            }" + NL + "            return resultErrorMessage;" + NL + "        }" + NL + "" + NL + "        void reset(){" + NL + "            ifPassedThrough = true;" + NL + "            errorCodeThrough = 0;" + NL + "            errorMessageThrough = \"\";" + NL + "            resultErrorCodeThrough = 0;" + NL + "            resultErrorMessageThrough = \"\";" + NL + "            tmpContentThrough = null;" + NL + "" + NL + "            ifPassed = true;" + NL + "            errorCode = 0;" + NL + "            errorMessage = \"\";" + NL + "        }" + NL;
  protected final String TEXT_73 = NL + "        void setRowValue_";
  protected final String TEXT_74 = "Struct ";
  protected final String TEXT_75 = ") {";
  protected final String TEXT_76 = NL + "            resultErrorCodeThrough = handleErrorCode(errorCodeThrough,resultErrorCodeThrough);" + NL + "            errorCodeThrough = 0;" + NL + "            resultErrorMessageThrough = handleErrorMessage(errorMessageThrough,resultErrorMessageThrough,\"";
  protected final String TEXT_77 = ":\");" + NL + "            errorMessageThrough = \"\";";
  protected final String TEXT_78 = NL + "        }";
  protected final String TEXT_79 = NL + "    }" + NL + "    RowSetValueUtil_";
  protected final String TEXT_80 = " rsvUtil_";
  protected final String TEXT_81 = " = new RowSetValueUtil_";
  protected final String TEXT_82 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    final INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    /*in shema:*/
    List<? extends IConnection> listInConns = node.getIncomingConnections();
    String sInConnName = null;
    IConnection inConn = null;
    List<IMetadataColumn> listInColumns = null;

    if (listInConns != null && listInConns.size() > 0) {
        IConnection inConnTemp = listInConns.get(0);
        sInConnName = inConnTemp.getName();
        if(inConnTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
            inConn = inConnTemp;
            listInColumns = inConnTemp.getMetadataTable().getListColumns();
        }
    }


    /* get the schema of itself (maybe no output flow)*/
    List<IMetadataColumn> listColumsToTest = node.getMetadataList().get(0).getListColumns();

    String anotherChecked = ElementParameterParser.getValue(node, "__CHECK_ANOTHER__");
    String checkAll = ElementParameterParser.getValue(node, "__CHECK_ALL__");
    final boolean bIsTrim = "true".equals(ElementParameterParser.getValue(node, "__SUB_STRING__"));
    final boolean useFasteDateChecker = "true".equals(ElementParameterParser.getValue(node, "__FAST_DATE_CHECK__"));
    final boolean useStrictDateChecker = "true".equals(ElementParameterParser.getValue(node, "__STRICT_DATE_CHECK__"));
    final boolean emptyIsNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTY_IS_NULL__"));
    final boolean allEmptyAreNull = "true".equals(ElementParameterParser.getValue(node, "__ALL_EMPTY_ARE_NULL__"));

    List<Map<String, String>> list = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__EMPTY_NULL_TABLE__");
    final List<String> listEmptyAsNull = new ArrayList<String>();
    for(Map<String, String> map : list){
        if("true".equals(map.get("EMPTY_NULL"))){
            listEmptyAsNull.add(map.get("SCHEMA_COLUMN"));
        }
    }

    class SchemaChecker { //CLASS SCHEMACHECKER START
        boolean anotherChecked = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ANOTHER__"));
        boolean ignoreTimeZone = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_TIMEZONE__"));

        public void  testDataType(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTDATATYPE START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
            String colName = metadataColumn.getLabel();

            if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00100 START

    stringBuffer.append(TEXT_1);
    
                if (_bNullable){ //CONDITION_00110 START

    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                    if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_6);
    
                    }
                }else if(!isPrimitive){ //CONDITION_00110 ELSE IF

    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                }else{ //CONDITION_00110 ELSE

    stringBuffer.append(TEXT_7);
    
                } //CONDITION_00110 STOP

    stringBuffer.append(TEXT_8);
    
                if(typeSelected.equals("Boolean") ) { //CONDITION_00120 START

    stringBuffer.append(TEXT_9);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_11);
    
                } else if(typeSelected.equals("Character")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_12);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_13);
    
                } else if(typeSelected.equals("BigDecimal")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_18);
    
                } else if(typeSelected.equals("Object")){ //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_19);
    
                } else { //CONDITION_00120 ELSE

    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_18);
    
                } //CONDITION_00120 STOP

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
            } //CONDITION_00100 STOP
        } //METHOD_TESTDATATYPE STOP

        public void testPrecision(int _maxLength, int iPrecision, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTPRECISION START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            String colName = metadataColumn.getLabel();
            boolean needCheck = false;
            if(anotherChecked) {
                if("BigDecimal".equalsIgnoreCase(typeSelected)) {
                    needCheck = true;
                }
            } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                /* NULLable, in case input value is Null, do nothing...
                Non-NULLable,
                    (1) in case input value is Non-null, go into...;
                    (2) in case input value is Null, do nothing and warning by NULL-CHECKER.
                */
                /*
                    if precision value is not empty or Null, checking "Precision" at first, if passed then checking "Length"
                */
                needCheck = true;
            }
            if(needCheck) { //CONDITION_00130 START

    stringBuffer.append(TEXT_24);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_25);
    
                if(javaType == JavaTypesManager.BIGDECIMAL) { //CONDITION_00131 START

    stringBuffer.append(TEXT_26);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_18);
    
                } else {  //CONDITION_00131 ELSE

    stringBuffer.append(TEXT_29);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_18);
    
                }  //CONDITION_00131 STOP

    stringBuffer.append(TEXT_31);
    
            } //CONDITION_00130 STOP
        } //METHOD_TESTPRECISION STOP

        public void testDataLength(boolean _bNullable, String _sInConnName,IMetadataColumn inColumn, IMetadataColumn metadataColumn, int maxLength, String cid) { //METHOD_TESTDATALENGTH START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, metadataColumn.isNullable());
            boolean bIsStringType = (javaType == JavaTypesManager.STRING), bIsIntegerType = (javaType == JavaTypesManager.INTEGER);
            String colName = inColumn.getLabel();

            if (maxLength > 0 && ( bIsStringType || bIsIntegerType )){ //CONDITION_00140 START

    stringBuffer.append(TEXT_24);
    
                if (_bNullable){ //CONDITION_00141 START

    stringBuffer.append(TEXT_32);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                    if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_6);
    
                    }
                }else if (!isPrimitive){ //CONDITION_00141 ELSE IF

    stringBuffer.append(TEXT_32);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                }else { //CONDITION_00141 ELSE

    stringBuffer.append(TEXT_34);
    
                } //CONDITION_00141 STOP

    stringBuffer.append(TEXT_35);
    
                if ( bIsTrim ){ //CONDITION_00142 START
                    if (bIsStringType) { //CONDITION_001421 START

    stringBuffer.append(TEXT_36);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_18);
    
                    } else if ( bIsIntegerType ){//CONDITION_001421 ELSE IF
                        String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                        if ("int".equals(generatedType)) { //CONDITION_0014211 START

    stringBuffer.append(TEXT_40);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_18);
    
                        } else{ //CONDITION_0014211 ELSE

    stringBuffer.append(TEXT_41);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_42);
    
                        } //CONDITION_0014211 STOP

    stringBuffer.append(TEXT_43);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_18);
    
                    } //CONDITION_001421 STOP
                } else{ //CONDITION_00142 ELSE
                    if (bIsStringType) { //CONDITION_001422 START

    stringBuffer.append(TEXT_45);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_46);
    
                    } else if (bIsIntegerType) { //CONDITION_001422 ELSE IF
                        String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                        if ("int".equals(generatedType)) { //CONDITION_0014221 START

    stringBuffer.append(TEXT_40);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_18);
    
                        } else { //CONDITION_0014221 ELSE

    stringBuffer.append(TEXT_41);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_42);
    
                        } //CONDITION_0014221 STOP

    stringBuffer.append(TEXT_47);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_46);
    
                    }//CONDITION_001422 STOP
                } //CONDITION_00142 STOP

    stringBuffer.append(TEXT_48);
    
            } //CONDITION_00140 STOP
        } //METHOD_TESTDATALENGTH STOP

        public void testDate(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String pattern, String cid) { //METHOD_TESTDATE START
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
            String colName = metadataColumn.getLabel();

            if ("".equals(pattern)){ //CONDITION_00150 START

    stringBuffer.append(TEXT_49);
    
            } else { //CONDITION_00150 ELSE
                if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00151 START

    stringBuffer.append(TEXT_50);
    
                    if (_bNullable){ //CONDITION_001511 START

    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                        if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_6);
    
                        }
                    }else if (!isPrimitive){ //CONDITION_001511 ELSE IF

    stringBuffer.append(TEXT_2);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_4);
    
                    }else { //CONDITION_001511 ELSE

    stringBuffer.append(TEXT_7);
    
                    } //CONDITION_001511 STOP

    stringBuffer.append(TEXT_51);
    
                    if (!useFasteDateChecker && !useStrictDateChecker) { //CONDITION_001512 START

    stringBuffer.append(TEXT_52);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_54);
    if(ignoreTimeZone){
    stringBuffer.append(TEXT_55);
    }else{
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    
                    } else if (useFasteDateChecker){ //CONDITION_001512 ELSE

    stringBuffer.append(TEXT_58);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_18);
    
                    } else {//CONDITION_001512 STOP

    stringBuffer.append(TEXT_60);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_57);
    
                    }

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                // date type need check also (some inputting data not legal, beacause original data is not suite with pattern and has be converted)
                } else if (javaType == JavaTypesManager.DATE){ //CONDITION_00151 ELSE IF
                    if (!metadataColumn.getPattern().equals(pattern)){ //CONDITION_001513 START

    stringBuffer.append(TEXT_63);
    
                    } //CONDITION_001513 STOP
                } else{ //CONDITION_00151 ELSE

    stringBuffer.append(TEXT_64);
    
                } //CONDITION_00151 STOP
            } //CONDITION_00150 STOP
        } //METHOD_TESTDATE STOP

        public void testNull(String _sInConnName, IMetadataColumn metadataColumn, String cid){ //METHOD_TESTNULL START
            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(metadataColumn.getTalendType(), metadataColumn.isNullable());
            if (!isPrimitive){ //CONDITION_00160 START
                if(emptyIsNull && !allEmptyAreNull){ //CONDITION_001601 START - for the migration task
                    if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016011 START

    stringBuffer.append(TEXT_65);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_67);
    
                    }else{ //CONDITION_0016011 ELSE

    stringBuffer.append(TEXT_68);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_69);
    
                    } //CONDITION_0016011 STOP
                }else{ //CONDITION_001601 ELSE
                    if(allEmptyAreNull){ //CONDITION_0016012 START

    stringBuffer.append(TEXT_65);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_67);
    
                    }else if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016012 ELSE IF

    stringBuffer.append(TEXT_65);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_67);
    
                    }else{ //CONDITION_0016012 ELSE

    stringBuffer.append(TEXT_68);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_69);
    
                    } //CONDITION_0016012 STOP
                } //CONDITION_001601 STOP

    stringBuffer.append(TEXT_70);
    
            } //CONDITION_00160 STOP
        } //METHOD_TESTNULL STOP
    } //CLASS SCHEMACHECKER STOP

    SchemaChecker checker = new SchemaChecker();
    List<Map<String, String>> listCheckedColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CHECKCOLS__");
    boolean bNeedReferSchema = false;

    if ("true".equals(anotherChecked)){
        if (node.getMetadataFromConnector("OTHER") != null)
            listColumsToTest = node.getMetadataFromConnector("OTHER").getListColumns();
    } else if ("true".equals(checkAll)){
        ;
    } else{
        bNeedReferSchema = true;
    }


    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
    for (IMetadataColumn inColumn : listInColumns) { //LOOP_00100 START
        int iInColIndex = listInColumns.indexOf(inColumn);
        if(iInColIndex % 100 == 0){ //CONDITION_00170 START

    stringBuffer.append(TEXT_73);
    stringBuffer.append((iInColIndex/100) );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn) );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sInConnName );
    stringBuffer.append(TEXT_75);
    
        } //CONDITION_00170 STOP
        // when using another schema, it's size may less than listInColumns
        if (iInColIndex >= listColumsToTest.size()){
            break;
        }

        Object pre_iPrecision = null;
        String sInColumnName = inColumn.getLabel(), sTestColName = null, sTestColType = null, sTestColPattern = null;
        boolean bNullable = true, bMaxLenLimited = true;
        /* use setting of tSchemaComplianceCheck schema (it is synchronize with inputting schema, but length value can be different) */
        Object pre_maxLength = listColumsToTest.get(iInColIndex).getLength();
        int maxLength = (pre_maxLength == null) ? 0 : Integer.parseInt(pre_maxLength.toString());
        IMetadataColumn schemaColumn = null;

        if (bNeedReferSchema) {
            Map<String, String> checkedColumn = listCheckedColumns.get(iInColIndex);
            sTestColName = checkedColumn.get("SCHEMA_COLUMN");
            sTestColType = checkedColumn.get("SELECTED_TYPE");
            sTestColPattern = checkedColumn.get("DATEPATTERN");
            bNullable = "true".equals(checkedColumn.get("NULLABLE"));
            bMaxLenLimited = "true".equals(checkedColumn.get("MAX_LENGTH"));
        } else{
            schemaColumn = listColumsToTest.get(iInColIndex);
            sTestColName = schemaColumn.getLabel();
            sTestColType = JavaTypesManager.getTypeToGenerate(schemaColumn.getTalendType(), true);
            sTestColPattern = schemaColumn.getPattern();
            bNullable = schemaColumn.isNullable();
            pre_iPrecision = schemaColumn.getPrecision();
        }

        // NULL checking
        if (!bNullable){
            checker.testNull(sInConnName, inColumn, cid);
        }

        // type checking
        if (sTestColType != null){
            if (sTestColType.indexOf("Date") >= 0){
                checker.testDate(bNullable, sInConnName, inColumn, sTestColPattern, cid);
            } else{
                checker.testDataType(bNullable, sInConnName, inColumn, sTestColType, cid);
            }
        }

        // length checking
        if (bMaxLenLimited){
            checker.testDataLength(bNullable, sInConnName,inColumn, "true".equals(anotherChecked)?schemaColumn:inColumn, maxLength, cid);
        }

        // precision checking
        if (pre_iPrecision != null){
            checker.testPrecision(maxLength, Integer.parseInt(pre_iPrecision.toString()), sInConnName, inColumn, sTestColType, cid);
        }

    stringBuffer.append(TEXT_76);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_77);
    
        if((iInColIndex + 1) % 100 == 0){ //CONDITION_00171 START

    stringBuffer.append(TEXT_78);
    
        } //CONDITION_00171 STOP
    } //LOOP_00100 STOP
    if(listInColumns.size() > 0 && listInColumns.size() % 100 > 0){ //CONDITION_00180 START

    stringBuffer.append(TEXT_78);
    
    } //CONDITION_00180 STOP

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_82);
    return stringBuffer.toString();
  }
}
