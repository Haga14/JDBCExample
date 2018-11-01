package liimo;
import java.awt.Dimension;
import java.sql.*;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class tablePrep {
	public static int RowCount;
	public static int ColCount;
	public static ResultSetMetaData MD;
	public static String[] colNames;
	public static Vector Rows;
	private static Object[][] TempRows;
	public JTable table;
	public JScrollPane tablePane;
	private static ResultSetMetaData metaData;
	
	public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
	public static ResultSetMetaData getRSMD(ResultSet rs) {
        try {
            metaData = rs.getMetaData();
            

            return metaData;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
	
	

}
