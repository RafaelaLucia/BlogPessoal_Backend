package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails { //implementa a interface UserDetails vindo do security

	/*
	 *  A interface UserDetails encapsula as informações do usuário 
	 *  necessárias para autenticá-lo e autorizá-lo em um sistema, como o 
	 *  nome de usuário, a senha, as permissões, etc. Essas informações são 
	 *  usadas pelo Spring Security para criar objetos de autenticação, que 
	 *  são usados para verificar a identidade do usuário e conceder ou 
	 *  negar acesso aos recursos do sistema..*/
	
	        private static final long serialVersionUID = 1L; // serve para garantir a compatibilidade de versão entre diferentes versões de uma classe Java quando ela é serializada(convertida em sequencia de bytes) e desserializada(convertida de volta a um objeto java).
	        
	        private String userName; //instancia o atributo userName que vem do framework
	        
	        private String password; //instancia o atributo senha que vem do framework
	        
	       /*Chama uma lista GrantedAuthority chamada authorities que 
	         serve pra ditar as permissões do sistema, ou seja, ele 
	         adiciona cargo de administrador, cargo de usuário comum, e 
	         assim vai dependendo do contexto da nossa aplicação*/
	        private List<GrantedAuthority> authorities; 
	
	        
	        public UserDetailsImpl (Usuario user) {
	        	this.userName = user.getUsuario();
	        	this.password = user.getSenha();
	        }
	        
	        public UserDetailsImpl() { } //construtor
	       
	        //Retorna as autoridades concedidas ao usuário.
	        @Override
	    	public Collection<? extends GrantedAuthority> getAuthorities() {
	    
	    		return authorities; //Retorna as autoridades concedidas ao usuário. Não é possível retornar nulo.
	    	
	        }

	        //Retorna a senha utilizada para autenticar o usuário.
	    	@Override
	    	public String getPassword() {
	    	
	    		return password; //Retorna a senha utilizada para autenticar o usuário.
	    	}

	    	//Retorna o nome de usuário usado para autenticar o usuário.
	    	@Override
	    	public String getUsername() {
	    		
	    		return userName; //Retorna o nome de usuário usado para autenticar o usuário. Não é possível retornar nulo.
	    	}

	    	//Indica se a conta do usuário expirou.
	    	@Override
	    	public boolean isAccountNonExpired() {
	    		
	    		return true; //true se a conta do usuário for válida (ou seja, não expirada), false se não for mais válida (ou seja, expirada)
	    	}

	    	//Indica se o usuário está bloqueado ou desbloqueado.
	    	@Override
	    	public boolean isAccountNonLocked() {
	    		
	    		return true; //verdadeiro se o usuário não estiver bloqueado, falso caso contrário
	    	}

	    	//Indica se as credenciais do usuário (senha) expiraram.
	    	@Override
	    	public boolean isCredentialsNonExpired() {
	    		
	    		return true;//true se as credenciais do usuário forem válidas (ou seja, não expiradas), false se não forem mais válidas (ou seja, expiradas)
	    	}

	    	//Indica se o usuário está habilitado ou desabilitado.
	        @Override
	    	public boolean isEnabled() {
	    		
	    		return true;//true se o usuário estiver habilitado, false caso contrário
	    	}
}
