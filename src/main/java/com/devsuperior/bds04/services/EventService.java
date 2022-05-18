package com.devsuperior.bds04.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository categoryRepository;

	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable) {
		Page<Event> list = repository.findAll(pageable);
		return list.map(i -> new EventDTO(i));
	}

	@Transactional(readOnly = true)
	public EventDTO findById(Long id) {
		Optional<Event> obj = repository.findById(id);
		/*
		 * Event entity = obj.orElseThrow(() -> new
		 * ResourceNotFoundException("Entity not found")); return new EventDTO(entity,
		 * entity.getCategories());
		 */return null;
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		copyDtoToEntity(dto, entity);
	//	entity.setName(dto.getName());
		entity = repository.save(entity);
		return new EventDTO(entity);
	}

	@Transactional
	public EventDTO update(EventDTO dto, long id) {
		/*
		 * try { Event entity = repository.getOne(id); copyDtoToEntity(dto, entity);
		 * entity.setName(dto.getName()); entity = repository.save(entity); return new
		 * EventDTO(entity); } catch (EntityNotFoundException e) { throw new
		 * ResourceNotFoundException("Id not found " + id); }
		 */
		return null;
	}

	public void delete(Long id) {
		/*
		 * try { repository.deleteById(id); } catch (EmptyResultDataAccessException e) {
		 * throw new ResourceNotFoundException("Id not found " + id); } catch
		 * (DataIntegrityViolationException e) { throw new
		 * DatabaseException("Integrity violation"); }
		 */
	}
	
	private void copyDtoToEntity(EventDTO dto, Event entity) {
		/*
		 * entity.setName(dto.getName()); entity.setPrice(dto.getPrice());
		 * entity.setDescription(dto.getDescription());
		 * entity.setImgUrl(dto.getImgUrl()); entity.setDate(dto.getDate());
		 * 
		 * entity.getCategories().clear(); for(CityDTO catDto : dto.getCategories()) {
		 * City category = categoryRepository.getOne(catDto.getId());
		 * entity.getCategories().add(category); }
		 */
	}
}
