package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.Writers;
import com.ktpo.kutuhanem.repo.WriterRepository;

@Service
public class WriterService {

	
	@Autowired
	WriterRepository repository;

	public List<Writers> getAllWriters() {
		List<Writers> writerList = repository.findAll();
		if (writerList.size() > 0)
			return writerList;
		else
			return new ArrayList<Writers>();

	}

	public Writers getWritersId(Long id) throws Exception {
		Optional<Writers> writer = repository.findById(id);

		if (writer.isPresent())
			return writer.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public Writers createOrUpdateWriter(Writers entity) throws Exception {
		return repository.save(entity);
	}

	public void deleteWriterById(Long id) throws Exception {
		Optional<Writers> writer = repository.findById(id);

		if (writer.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
