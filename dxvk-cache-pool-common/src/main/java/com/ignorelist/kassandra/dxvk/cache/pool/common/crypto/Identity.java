/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignorelist.kassandra.dxvk.cache.pool.common.crypto;

import java.util.Objects;
import javax.validation.constraints.Email;

/**
 *
 * @author poison
 */
public class Identity {

	private PublicKey publicKey;
	@Email
	private String email;
	private String name;

	public Identity() {
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey=publicKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	@Override
	public int hashCode() {
		int hash=7;
		hash=37*hash+Objects.hashCode(this.publicKey);
		hash=37*hash+Objects.hashCode(this.email);
		hash=37*hash+Objects.hashCode(this.name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj==null) {
			return false;
		}
		if (getClass()!=obj.getClass()) {
			return false;
		}
		final Identity other=(Identity) obj;
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.publicKey, other.publicKey)) {
			return false;
		}
		return true;
	}

}
