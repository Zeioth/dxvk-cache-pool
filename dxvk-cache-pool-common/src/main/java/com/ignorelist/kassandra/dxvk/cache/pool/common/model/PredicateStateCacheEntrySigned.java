/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ignorelist.kassandra.dxvk.cache.pool.common.model;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author poison
 */
@XmlRootElement
public class PredicateStateCacheEntrySigned implements Serializable, Predicate<StateCacheEntrySignees> {

	public static final int DEFAULT_SIGNATURE_MINIMUM=2;

	public static final Predicate<StateCacheEntrySignees> DEFAULT_PREDICATE=new PredicateMinimumSignatures(DEFAULT_SIGNATURE_MINIMUM);

	private PredicateAcceptedPublicKeys acceptedPublicKeys;
	private PredicateMinimumSignatures minimumSignatures;
	private boolean onlyAcceptVerifiedKeys;

	public PredicateStateCacheEntrySigned() {
	}

	public PredicateStateCacheEntrySigned(PredicateAcceptedPublicKeys acceptedPublicKeys, PredicateMinimumSignatures minimumSignatures) {
		this.acceptedPublicKeys=acceptedPublicKeys;
		this.minimumSignatures=minimumSignatures;
	}

	public PredicateAcceptedPublicKeys getAcceptedPublicKeys() {
		return acceptedPublicKeys;
	}

	public void setAcceptedPublicKeys(PredicateAcceptedPublicKeys acceptedPublicKeys) {
		this.acceptedPublicKeys=acceptedPublicKeys;
	}

	public PredicateMinimumSignatures getMinimumSignatures() {
		return minimumSignatures;
	}

	public void setMinimumSignatures(PredicateMinimumSignatures minimumSignatures) {
		this.minimumSignatures=minimumSignatures;
	}

	public boolean isOnlyAcceptVerifiedKeys() {
		return onlyAcceptVerifiedKeys;
	}

	public void setOnlyAcceptVerifiedKeys(boolean onlyAcceptVerifiedKeys) {
		this.onlyAcceptVerifiedKeys=onlyAcceptVerifiedKeys;
	}

	@Override
	public boolean apply(StateCacheEntrySignees input) {
		if (null==acceptedPublicKeys&&null==minimumSignatures) {
			return DEFAULT_PREDICATE.apply(input);
		}
		return Predicates
				.and(
						null==acceptedPublicKeys ? Predicates.alwaysTrue() : acceptedPublicKeys,
						null==minimumSignatures ? Predicates.alwaysTrue() : minimumSignatures)
				.apply(input);
	}

	@Override
	public String toString() {
		return "PredicateStateCacheEntrySigned{"+"acceptedPublicKeys="+acceptedPublicKeys+", minimumSignatures="+minimumSignatures+", onlyAcceptVerifiedKeys="+onlyAcceptVerifiedKeys+'}';
	}

}
