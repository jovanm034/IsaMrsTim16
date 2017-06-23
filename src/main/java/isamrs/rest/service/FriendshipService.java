package isamrs.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import isamrs.rest.domain.Friendship;
import isamrs.rest.repository.FriendshipRepository;

@Service
public class FriendshipService {
	
	@Autowired
	private FriendshipRepository friendshipRepository;
	
	public Page<Friendship> findAll() {
		return friendshipRepository.findAll(null);
		
	}

	public Friendship create(Friendship friendship) {
		return friendshipRepository.save(friendship);
	}

}
