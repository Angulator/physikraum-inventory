-- Seed admin user (BCrypt of 'admin123')
INSERT INTO users (username, password, role, enabled) VALUES (
  'admin',
  '$2a$10$E9O5YkGq6bJ8o6s1oQ7m2u6T7c0r4r9S1r1i9QxA6fV6RrM1Q1lbe',
  'ROLE_ADMIN',
  true
) ON CONFLICT DO NOTHING;
