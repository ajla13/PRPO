package prpo;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseDaoImpl implements BaseDao {
    private static Logger log = Logger.getLogger(BaseDaoImpl.class.getName());
    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            InitialContext initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("jdbc/SimpleJdbcDS");
            con = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public Entiteta vrni(int id) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        try {

            String sql = "SELECT * FROM uporabnik WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return getUporabnikFromRS(rs);
            } else {
                log.info("Uporabnik ne obstaja");
            }

        } catch (SQLException e) {
            log.severe(e.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.severe(e.toString());
                }
            }
        }
        return null;
    }

    @Override
    public void vstavi(Entiteta ent) {
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            Uporabnik u = (Uporabnik) ent;
            u.setId(4);
            System.out.println("user id:" + u.getId());
            String sql = String.format("INSERT INTO public.\"uporabnik\" (id, ime, priimek, uporabnisko_ime) " +
                            "VALUES ('%s', '%s', '%s', '%s')",
                    u.getId(), u.getIme(), u.getPriimek(), u.getUporabnisko_ime());
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.severe(e.toString());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    log.severe(e.toString());
                }
            }
        }
    }

    @Override
    public void odstrani(int id) {
        PreparedStatement ps = null;
        Connection con = null;
        try {
            if (con == null) {
                con = getConnection();
            }
            String sql = "DELETE FROM public.\"uporabnik\" WHERE id =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Uporabnik getUporabnikFromRS(ResultSet rs) throws SQLException {

        String ime = rs.getString("ime");
        String priimek = rs.getString("priimek");
        String uporabniskoIme = rs.getString("uporabniskoime");
        return new Uporabnik(ime, priimek, uporabniskoIme);

    }
}
