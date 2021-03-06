package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IBeerRepository;
import dao.uow.IUnitOfWork;
import domain.model.Beer;
import domain.model.Client;

public class BeerRepository extends RepositoryBase<Beer>
implements IBeerRepository {

	public BeerRepository(Connection connection,
                          IMapResultSetIntoEntity<Beer> mapper, IUnitOfWork uow) {
		super(connection,mapper, uow);
	}

		@Override
		protected String createTableSql() {
			return "CREATE TABLE beers("
					+ "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY ,"
					+ "NAME varchar(20),"
					+ "BREWERY varchar(20),"
					+ "STYLE varchar(20),"
					+ "IBU int,"
					+ ")";
		}

		@Override
		protected String tableName() {
			return "beers";
		}
		
		protected String insertSql() {
			return "INSERT INTO beers(NAME,BREWERY,STYLE,IBU) VALUES (?,?,?,?)";
		}
		
		protected String updateSql() {
			return "UPDATE beers SET (NAME,BREWERY,STYLE,IBU) VALUES (?,?,?,?) WHERE id=?";
		}
		
		@Override
		protected void setUpdate(Beer entity) throws SQLException {
			update.setString(1, entity.getName());
			update.setString(2, entity.getBrewery());
			update.setString(3, entity.getStyle());
			update.setInt(4, entity.getIbu());
			
		}

		@Override
		protected void setInsert(Beer entity) throws SQLException {
			update.setString(1, entity.getName());
			update.setString(2, entity.getBrewery());
			update.setString(3, entity.getStyle());
			update.setInt(4, entity.getIbu());
		}

		public List<Beer> byPerson(Client client) {
			// TODO Auto-generated method stub
			return null;
		}	
	}

