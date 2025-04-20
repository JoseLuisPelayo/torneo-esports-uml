package org.torneo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbsGenericImplMy8 {

    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected String sql;
    protected  int rows;

    public AbsGenericImplMy8() {
        conn = ConnectionMy8.getConnection();
    }

}
