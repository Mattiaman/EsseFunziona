package persistence;

import java.util.List;

import model.Studio;

public interface StudioDAO {

	public void save(Studio studio);

	public Studio findByPrimaryKey(long id);

	public List<Studio> findAll();

	public void delete(Studio studio);

	public void update(Studio studio);

}
