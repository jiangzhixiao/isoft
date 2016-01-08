package io.isoft.base.filter;

import java.util.ArrayList;
import java.util.List;


//This class basically takes a Flexicious Filter, and converts it to an HSQL statment.
public class FilterBuilder {

	
	public FilterBuilder()
    {
        parameters = new ArrayList<ObjectParameter>();
    }
	
	public static String FILTER_OPERATION_TYPE_NONE = "None";
    public static String FILTER_OPERATION_TYPE_EQUALS = "Equals";
    public static String FILTER_OPERATION_TYPE_NOT_EQUALS = "NotEquals";
    public static String FILTER_OPERATION_TYPE_BEGINS_WITH = "BeginsWith";
    public static String FILTER_OPERATION_TYPE_ENDS_WITH = "EndsWith";
    public static String FILTER_OPERATION_TYPE_CONTAINS = "Contains";
    public static String FILTER_OPERATION_TYPE_DOSE_NOT_CONTAIN = "DoesNotContain";
    public static String FILTER_OPERATION_TYPE_GREATER_THAN = "GreaterThan";
    public static String FILTER_OPERATION_TYPE_LESS_THAN = "LessThan";
    public static String FILTER_OPERATION_TYPE_GREATERTHANEQUALS = "GreaterThanEquals";
    public static String FILTER_OPERATION_TYPE_LESS_THAN_EQUALS = "LessThanEquals";
    public static String FILTER_OPERATION_TYPE_IN_LIST = "InList";
    public static String FILTER_OPERATION_TYPE_NOT_IN_LIST = "NotInList";
    public static String FILTER_OPERATION_TYPE_BETWEEN = "Between";
    public static String FILTER_OPERATION_TYPE_IS_NOT_NULL = "IsNotNull";
    public static String FILTER_OPERATION_TYPE_IS_NULL = "IsNull";
    
    private int _paramStartIndex = 0;
    public List<ObjectParameter> parameters;
    
    public String buildHql(MyFilter filter, String tablePrefix)
    {
        parameters = new ArrayList<ObjectParameter>();
        int parameterIndex = _paramStartIndex;
        String parameterPrefix = ":";
        StringBuilder sqlStatementBuilder = new StringBuilder(100);

        for (int nFilterExpression = 0; nFilterExpression < filter.arguments.size(); nFilterExpression++)
        {
            MyFilterExpression filterExpression = (MyFilterExpression)filter.arguments.get(nFilterExpression);
            
            if (nFilterExpression != 0)
            {
                    sqlStatementBuilder.append(" AND ");
            }
            sqlStatementBuilder.append(tablePrefix + "." + filterExpression.columnName);

            if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_BEGINS_WITH))
            {
                String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" like " + parameterPrefix+paramName);
                 parameters.add(new ObjectParameter(paramName, filterExpression.expression + "%",filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_CONTAINS))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" like " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, "%" + filterExpression.expression +  "%",filterExpression.columnName));
            }
            
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_DOSE_NOT_CONTAIN))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" not like " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, "%" + filterExpression.expression +  "%",filterExpression.columnName));
            }
            
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_ENDS_WITH))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" like " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, "%" + filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_EQUALS))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" = " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_IS_NOT_NULL))
            {
                sqlStatementBuilder.append(" is not null");
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_IS_NULL))
            {
                sqlStatementBuilder.append(" is null");
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_NOT_EQUALS))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" <> " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_GREATER_THAN))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" > " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_GREATERTHANEQUALS))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" >= " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_LESS_THAN))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" < " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_LESS_THAN_EQUALS))
            {
            	String paramName = String.format("param%s", parameterIndex++);
                sqlStatementBuilder.append(" <= " + parameterPrefix + paramName);
                parameters.add(new ObjectParameter(paramName, filterExpression.expression,filterExpression.columnName));
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_IN_LIST)
                || filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_NOT_IN_LIST))
            {
//                Object[] inList = (Object[])filterExpression.expression;
                ArrayList inList = (ArrayList)filterExpression.expression;
                if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_NOT_IN_LIST))
                {
                    sqlStatementBuilder.append(" NOT ");
                }

                sqlStatementBuilder.append(" IN (");
//                for (int i = 0; i < inList.length; i++)
//                {
//                    String paramName = String.format("param%s", parameterIndex++);
//                    sqlStatementBuilder.append(parameterPrefix + paramName + ((i != (inList.length - 1)) ? "," : ""));
//                    parameters.add(new ObjectParameter(paramName, inList[i],filterExpression.columnName));
//                }
                for (int i = 0; i < inList.size(); i++)
                {
                    String paramName = String.format("param%s", parameterIndex++);
                    sqlStatementBuilder.append(parameterPrefix + paramName + ((i != (inList.size() - 1)) ? "," : ""));
                    parameters.add(new ObjectParameter(paramName, inList.get(i),filterExpression.columnName));
                }
                sqlStatementBuilder.append(" )");
            }
            else if (filterExpression.filterOperation.equals(FILTER_OPERATION_TYPE_BETWEEN))
            {
            	String rangeStartParamName = String.format("param%s", parameterIndex++);
            	String rangeEndParamName = String.format("param%s", parameterIndex++);
                Object[] betweenList = (Object[])filterExpression.expression;
                if (betweenList.length != 2)
                    throw new UnsupportedOperationException("Expression for between operation should only contain two operands: " + filterExpression.columnName);
                sqlStatementBuilder.append(" BETWEEN ");
                sqlStatementBuilder.append(String.format(" %s AND %s", parameterPrefix + rangeStartParamName, parameterPrefix + rangeEndParamName));
                sqlStatementBuilder.append(" ");
                parameters.add(new ObjectParameter(rangeStartParamName, betweenList[0],filterExpression.columnName));
                parameters.add(new ObjectParameter(rangeEndParamName, betweenList[1],filterExpression.columnName));
            }
            else
                throw new UnsupportedOperationException("FilterExpression not implemented: " + filterExpression.filterOperation);
        }
        return sqlStatementBuilder.toString();
    }
    
 

}
