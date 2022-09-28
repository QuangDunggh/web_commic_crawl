package com.readComics.bpo.repositories.authorRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.readComics.bpo.model.AuthorComic;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorComic, Long> {

}
