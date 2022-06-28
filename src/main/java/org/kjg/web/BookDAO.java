package org.kjg.web;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BookDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void insert(BookDTO bdt) {
		System.out.println(bdt.toString());
		sqlSessionTemplate.insert("insert", bdt);
	}

	public List<BookDTO> selectAll() {
		return sqlSessionTemplate.selectList("list");
	}
		
	public List<BookDTO> selectSearch(BookDTO bdt) {
		return sqlSessionTemplate.selectList("selectSearch", bdt);
	}
	
	public BookDTO selectByTitle(String title) {
		return sqlSessionTemplate.selectOne("selectSearch", title);
	}
	
	public int bookCount() {
		return sqlSessionTemplate.selectOne("countBook");
	}
	
	public List<BookDTO> selectBook(PagingVO pv) {
		return sqlSessionTemplate.selectList("selectBook", pv);
	}

}
