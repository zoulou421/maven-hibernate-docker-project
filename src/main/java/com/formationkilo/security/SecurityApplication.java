package com.formationkilo.security;

import java.util.ArrayList;
import java.util.List;

import com.formationkilo.security.dao.AppRoleImpl;
import com.formationkilo.security.dao.AppUserImpl;
import com.formationkilo.security.dao.IAppRole;
import com.formationkilo.security.dao.IAppUser;
import com.formationkilo.security.entities.AppRole;
import com.formationkilo.security.entities.AppUser;

public class SecurityApplication {

	public static void main(String[] args) {
		
		IAppRole roledao = new AppRoleImpl();
		AppRole role= new AppRole();
		role.setName("ROLE_USER");
		
		//int result =roledao.save(role);
		//System.out.println(result);
		
		//roledao.getAll().forEach(r->System.out.println(r.getName()));
		
		
		AppUser appUser= new AppUser();
		appUser.setFirstName("Bonevy");
		appUser.setLastName("BEBY");
		appUser.setEmail("bonevybeby@formationkilo.com");
		appUser.setPassword("passer123");
		List<AppRole> roles = new ArrayList<AppRole>();
		roles.add(roledao.get(1));//les roles doivent venir de la base de données
		roles.add(roledao.get(2));//les roles doivent venir de la base de données
        appUser.setRoles(roles);
        
        IAppUser userdao = new AppUserImpl();
        int result=userdao.save(appUser);
        if(result==1) {
        	System.out.println("User et role bien ajouté");
        }else {
        	System.out.println("pas de succès ajout User");
        }
        
        
        
	}

}
