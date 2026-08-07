package com.ekko.anime_tracker.identity.domain;

import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {

  @EqualsAndHashCode.Include private Long id;
  private String username; // doit être unique
  private String email; // doit être unique
  private String passwordHash;
  private Instant createdAt;
  private UserStatus status;
  private Set<String> roles;
}
