/*
  Warnings:

  - The primary key for the `product` table will be changed. If it partially fails, the table could be left without primary key constraint.
  - Changed the type of `id` on the `product` table. No cast exists, the column would be dropped and recreated, which cannot be done if there is data, since the column is required.

*/
-- AlterTable
ALTER TABLE "product" DROP CONSTRAINT "product_pkey",
DROP COLUMN "id",
ADD COLUMN     "id" UUID NOT NULL,
ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");
