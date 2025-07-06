# System Design Essentials

> These are the essential topics for understanding system design.

---
### **[Low Level Design](./Low%20Level%20Design.md)**

---

### **[1. System Design Basics](./System%20Design%20Basics.md)**

* **High-Level Design Approach** —
  * Functional vs Non-functional requirements.
* **Latency, Throughput, Availability, Reliability, Consistency, Scalability, Maintainability.**
* **CAP Theorem (Consistency, Availability, Partition Tolerance).**
* **Trade-offs: Speed vs Consistency, Cost vs Scalability.**

---

### **2. Load Handling**

* **Load Balancing.**
  * (Round Robin, Least Connections, IP Hashing).
* **Reverse Proxy.**
  * (Nginx, HAProxy, Envoy)
* **Horizontal vs Vertical Scaling.**
* **Auto-scaling Groups (AWS, GCP).**

---

### **3. Data Storage**

* **SQL vs NoSQL (when to pick which).**
* **Relational DB (PostgreSQL, MySQL) Design — Indexing, Joins, Transactions (ACID).**
* **NoSQL (MongoDB, DynamoDB) — Document, Key-Value, Columnar.**
* **Sharding, Replication, Partitioning.**
* **Caching (Redis, Memcached) — Read-heavy optimizations.**

---

### **4. Caching Systems**

* **Client-Side, Server-Side, CDN Caching (Cloudflare, Akamai).**
* **Cache Invalidation Strategies (Write-Through, Write-Back, TTL).**
* **Redis vs Memcached differences.**

---

### **5. Data Consistency**

* **Eventual Consistency vs Strong Consistency.**
* **Quorum-based Reads/Writes.**
* **Leader Election (Raft, Paxos overview).**

---

### **6. Messaging and Asynchronous Systems**

* **Message Queues (RabbitMQ, Kafka, SQS).**
* **Task Queues (Celery, Bull.js).**
* **Pub/Sub Systems — Real-time event streaming (Kafka, Redis Streams).**
* **Retry Mechanisms, Dead Letter Queues.**

---

### **7. API & Request Handling**

* **API Gateway (Kong, AWS API Gateway).**
* **Rate Limiting (Token Bucket, Leaky Bucket).**
* **Circuit Breakers, Retry Patterns, Idempotency.**

---

### **8. File Storage & Media Handling**

* **Blob Storage (S3, GCS) for files/images/videos.**
* **Presigned URLs.**
* **CDN for static file delivery.**

---

### **9. Authentication & Authorization**

* **JWT vs Session-based Auth.**
* **OAuth2.0 / OpenID Connect (Google Login, Facebook Login).**
* **API Key vs OAuth vs Custom Token.**

---

### **10. Real-Time Systems**

* **WebSocket vs Long Polling vs Server-Sent Events.**
* **Real-time Chat, Notification Design.**

---

### **11. Fault Tolerance & Resiliency**

* **Redundancy, Failover Strategies.**
* **Graceful Degradation.**
* **Health Checks, Heartbeats.**
* **Disaster Recovery.**

---

### **12. Observability & Monitoring**

* **Logging (ELK Stack).**
* **Tracing (Jaeger, Zipkin).**
* **Metrics (Prometheus, Grafana).**
* **Alerting Systems.**

---

### **13. CDNs & Global Scale Systems**

* **Content Delivery Networks.**
* **Geo-Distributed Systems Challenges.**
* **Latency Optimization across regions.**

---

### **14. Designing Real-World Systems (Case Studies)**

* **URL Shortener.**
* **Instagram Feed / Twitter Timeline.**
* **Uber Location Tracking.**
* **YouTube/Netflix Video Streaming.**
* **WhatsApp Messaging System.**

---

### **Optional (Advanced) Topics:**

* Consistent Hashing.
* Bloom Filters.
* CRDTs / Conflict Resolution in distributed systems.
* Data Lakes vs Data Warehouses.

---

