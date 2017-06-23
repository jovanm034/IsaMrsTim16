package isamrs.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import isamrs.rest.domain.Friendship;

public interface FriendshipRepository extends Repository<Friendship, Long> {
	
	public Page<Friendship> findAll(Pageable pageable);
	public Friendship save(Friendship friendship);
}
