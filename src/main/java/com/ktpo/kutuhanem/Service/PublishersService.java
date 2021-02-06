package com.ktpo.kutuhanem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktpo.kutuhanem.model.Publishers;
import com.ktpo.kutuhanem.repo.PublishersRepository;

@Service
public class PublishersService {

	@Autowired
	PublishersRepository repository;

	public List<Publishers> getAllPublishers() {
		List<Publishers> publishersList = repository.findAll();
		if (publishersList.size() > 0)
			return publishersList;
		else
			return new ArrayList<Publishers>();

	}

	public Publishers getPublishersId(Long id) throws Exception {
		Optional<Publishers> publishers = repository.findById(id);

		if (publishers.isPresent())
			return publishers.get();
		else
			throw new Exception("No employee record exist for given id");
	}

	public Publishers createOrUpdatePublishers(Publishers entity) throws Exception {
		return repository.save(entity);
	}

	public void deletePublishersById(Long id) throws Exception {
		Optional<Publishers> publishers = repository.findById(id);

		if (publishers.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
