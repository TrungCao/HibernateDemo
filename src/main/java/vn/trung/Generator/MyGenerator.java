package vn.trung.Generator;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.spi.QueryImplementor;

import vn.trung.model.Employee;

public class MyGenerator implements IdentifierGenerator {

	private String prefix = "emp";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String query = "Select id from Employee";
		Stream<String> ids = session.createQuery(query).stream();
		Integer max = 0;

		List<String> str = session.createQuery(query).list();
		if (str.size() > 0) {
			max = str.stream().map(n -> Integer.parseInt(n.replace("emp", ""))).max(Integer::compare).get();
		}

		return prefix + (String.format("%04d", max + 1));
	}

}
