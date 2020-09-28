package com.cg.ows.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ows.model.OnlineWalletSystem;

@Repository
public interface OnlineWalletSystemRepository extends JpaRepository<OnlineWalletSystem, BigInteger> {

	@Query(value = "select * from online_wallet_system_tbl where account_id = ?1", nativeQuery = true)
	List<OnlineWalletSystem> getAccountDetails(BigInteger accountId);

	


}
