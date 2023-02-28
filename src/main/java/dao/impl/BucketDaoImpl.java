package dao.impl;

import connection.ConnectionUtils;
import dao.BucketDao;
import domain.Bucket;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public class BucketDaoImpl implements BucketDao {
    private  static String READ_BY_ALL 			= "SELECT * FROM bucket";
    private  static String READ_BY_ALLID 		= "SELECT * FROM bucket WHERE userId=?";
    private static String CREATE = "insert into bucket(`userId`,`magazineId`, `purchaseDate`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String UPDATE_BY_ID = "update bucket set userId=?, magazineId = ?, purchaseDate = ?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";


    private Connection connection;
    private PreparedStatement preparedStatement;
    private static final Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);

    public BucketDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Bucket create(Bucket bucket) {
        try {

            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());

            long millis=System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            preparedStatement.setDate(3, date);
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);


            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer idBucket = result.getInt("id");
            Integer userId = result.getInt("userId");
            Integer productId = result.getInt("magazineId");
            Date purchaseDate = result.getDate("purchaseDate");


            bucket = new Bucket(idBucket, userId, productId, purchaseDate);

        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, (java.sql.Date) bucket.getPurchaseDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucket;

    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<Bucket> readAll() {
        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer idBucket = result.getInt("id");
                Integer userId = result.getInt("userId");
                Integer productId = result.getInt("magazineId");
                Date purchaseDate = result.getDate("purchaseDate");

                bucketRecords.add(new Bucket(idBucket, userId, productId, purchaseDate));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucketRecords;
    }

    @Override
    public List<Bucket> readAllId(Integer id) {
        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ALLID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer idBucket = result.getInt("id");
                Integer userId = result.getInt("userId");
                Integer productId = result.getInt("magazineId");
                Date purchaseDate = result.getDate("purchaseDate");

                bucketRecords.add(new Bucket(idBucket, userId, productId, purchaseDate));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return bucketRecords;
    }

}
