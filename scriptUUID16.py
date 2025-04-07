import uuid
import base64

# Generar un UUID
cluster_uuid = uuid.uuid4()

# Codificar en base64
base64_uuid = base64.urlsafe_b64encode(cluster_uuid.bytes).decode('utf-8')

print(base64_uuid)
