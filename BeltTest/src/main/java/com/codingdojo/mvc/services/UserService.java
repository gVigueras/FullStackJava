package com.codingdojo.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.mvc.models.User;
import com.codingdojo.mvc.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;

	public UserService (UserRepository a) {
		this.userRepo = a;
	}

	public User createUser(User c) {
		return userRepo.save(c);
	}

	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public String authenticateUser(String email, String password) {
		// primero encontrar el usuario por su email
		User user = userRepo.findByEmail(email);
		// si no lo podemos encontrar por su email, retornamos false
		if(user == null) {
			return "No existe una cuenta con este correo";
		} else {
			// si el password coincide devolvemos true, sino, devolvemos false
			if(password.equals(user.getPassword())) {
				return "listo";
			} else {
				return "Contraseña Incorrecta";
			}
		}
	}
}