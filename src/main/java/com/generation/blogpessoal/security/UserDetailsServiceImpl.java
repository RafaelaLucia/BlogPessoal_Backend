package com.generation.blogpessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	//permite autenticar um usuário baseando-se na sua existência no Banco de dados 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*Localiza o usuário com base no nome de usuário. Na implementação 
	 *real, a pesquisa pode possivelmente diferenciar maiúsculas de 
	 *minúsculas ou não, dependendo de como a instância de implementação 
	 *está configurada. Nesse caso, o objeto UserDetails que retorna pode 
	 *ter um nome de usuário diferente do que foi realmente solicitado.*/
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userName);
		
		if(usuario.isPresent()) {
			return new UserDetailsImpl(usuario.get()); //retornar um Objeto da Classe UserDetailsImpl com os dados encontrados no Banco de dados.
		}else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN); //403 - acesso proibido
		}
		
	}

}
