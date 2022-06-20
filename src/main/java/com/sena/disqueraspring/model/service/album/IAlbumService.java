package com.sena.disqueraspring.model.service.album;

import com.sena.disqueraspring.model.Album;

import java.util.List;

public interface IAlbumService {

    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer idAlbum);
    public void delete(Integer idAlbum);
}
