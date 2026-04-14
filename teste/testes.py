import matplotlib.pyplot as plt
import pandas as pd

# Dados fornecidos (Atualizados)
dados_colisoes = {
    'qtd_jogadores': [1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000],
    'Linear': [20270, 10210, 11000, 13290, 9400, 23840, 18660, 42390, 24860, 47200],
    'Quadratica': [2804, 4272, 5256, 6854, 6406, 9217, 10896, 15038, 13017, 20639]
}

df = pd.DataFrame(dados_colisoes)

# Criando o gráfico
plt.figure(figsize=(12, 6))

# Plotando as duas linhas
plt.plot(df['qtd_jogadores'], df['Linear'], marker='o', label='Sondagem Linear', color='red', linewidth=2)
plt.plot(df['qtd_jogadores'], df['Quadratica'], marker='s', label='Sondagem Quadrática', color='blue', linewidth=2)

# Títulos e legendas
plt.title('Performance de Tabela Hash: Colisões Totais (Linear vs Quadrática)', fontsize=14)
plt.xlabel('Quantidade de Jogadores', fontsize=12)
plt.ylabel('Número Total de Colisões', fontsize=12)
plt.legend()
plt.grid(True, linestyle='--', alpha=0.6)

# Ajuste para garantir que todos os números no eixo X apareçam
plt.xticks(df['qtd_jogadores'])

plt.tight_layout()
plt.show()

# Exportar para CSV
df.to_csv('comparativo_colisoes_v2.csv', index=False)