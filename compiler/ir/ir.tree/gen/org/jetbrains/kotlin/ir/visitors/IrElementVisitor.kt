/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/ir/ir.tree/tree-generator/ReadMe.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.ir.visitors

import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*

interface IrElementVisitor<out R, in D> {

    fun visitElement(element: IrElement, data: D): R

    fun visitDeclaration(declaration: IrDeclarationBase, data: D): R = visitElement(declaration, data)

    fun visitValueParameter(declaration: IrValueParameter, data: D): R = visitDeclaration(declaration, data)

    fun visitClass(declaration: IrClass, data: D): R = visitDeclaration(declaration, data)

    fun visitAnonymousInitializer(declaration: IrAnonymousInitializer, data: D): R = visitDeclaration(declaration, data)

    fun visitTypeParameter(declaration: IrTypeParameter, data: D): R = visitDeclaration(declaration, data)

    fun visitFunction(declaration: IrFunction, data: D): R = visitDeclaration(declaration, data)

    fun visitConstructor(declaration: IrConstructor, data: D): R = visitFunction(declaration, data)

    fun visitEnumEntry(declaration: IrEnumEntry, data: D): R = visitDeclaration(declaration, data)

    fun visitErrorDeclaration(declaration: IrErrorDeclaration, data: D): R = visitDeclaration(declaration, data)

    fun visitField(declaration: IrField, data: D): R = visitDeclaration(declaration, data)

    fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty, data: D): R = visitDeclaration(declaration, data)

    fun visitModuleFragment(declaration: IrModuleFragment, data: D): R = visitElement(declaration, data)

    fun visitProperty(declaration: IrProperty, data: D): R = visitDeclaration(declaration, data)

    fun visitScript(declaration: IrScript, data: D): R = visitDeclaration(declaration, data)

    fun visitSimpleFunction(declaration: IrSimpleFunction, data: D): R = visitFunction(declaration, data)

    fun visitTypeAlias(declaration: IrTypeAlias, data: D): R = visitDeclaration(declaration, data)

    fun visitVariable(declaration: IrVariable, data: D): R = visitDeclaration(declaration, data)

    fun visitPackageFragment(declaration: IrPackageFragment, data: D): R = visitElement(declaration, data)

    fun visitExternalPackageFragment(declaration: IrExternalPackageFragment, data: D): R = visitPackageFragment(declaration, data)

    fun visitFile(declaration: IrFile, data: D): R = visitPackageFragment(declaration, data)

    fun visitExpression(expression: IrExpression, data: D): R = visitElement(expression, data)

    fun visitBody(body: IrBody, data: D): R = visitElement(body, data)

    fun visitExpressionBody(body: IrExpressionBody, data: D): R = visitBody(body, data)

    fun visitBlockBody(body: IrBlockBody, data: D): R = visitBody(body, data)

    fun visitDeclarationReference(expression: IrDeclarationReference, data: D): R = visitExpression(expression, data)

    fun visitMemberAccess(expression: IrMemberAccessExpression<*>, data: D): R = visitDeclarationReference(expression, data)

    fun visitFunctionAccess(expression: IrFunctionAccessExpression, data: D): R = visitMemberAccess(expression, data)

    fun visitConstructorCall(expression: IrConstructorCall, data: D): R = visitFunctionAccess(expression, data)

    fun visitSingletonReference(expression: IrGetSingletonValue, data: D): R = visitDeclarationReference(expression, data)

    fun visitGetObjectValue(expression: IrGetObjectValue, data: D): R = visitSingletonReference(expression, data)

    fun visitGetEnumValue(expression: IrGetEnumValue, data: D): R = visitSingletonReference(expression, data)

    fun visitRawFunctionReference(expression: IrRawFunctionReference, data: D): R = visitDeclarationReference(expression, data)

    fun visitContainerExpression(expression: IrContainerExpression, data: D): R = visitExpression(expression, data)

    fun visitBlock(expression: IrBlock, data: D): R = visitContainerExpression(expression, data)

    fun visitComposite(expression: IrComposite, data: D): R = visitContainerExpression(expression, data)

    fun visitSyntheticBody(body: IrSyntheticBody, data: D): R = visitBody(body, data)

    fun visitBreakContinue(jump: IrBreakContinue, data: D): R = visitExpression(jump, data)

    fun visitBreak(jump: IrBreak, data: D): R = visitBreakContinue(jump, data)

    fun visitContinue(jump: IrContinue, data: D): R = visitBreakContinue(jump, data)

    fun visitCall(expression: IrCall, data: D): R = visitFunctionAccess(expression, data)

    fun visitCallableReference(expression: IrCallableReference<*>, data: D): R = visitMemberAccess(expression, data)

    fun visitFunctionReference(expression: IrFunctionReference, data: D): R = visitCallableReference(expression, data)

    fun visitPropertyReference(expression: IrPropertyReference, data: D): R = visitCallableReference(expression, data)

    fun visitLocalDelegatedPropertyReference(expression: IrLocalDelegatedPropertyReference, data: D): R = visitCallableReference(expression, data)

    fun visitClassReference(expression: IrClassReference, data: D): R = visitDeclarationReference(expression, data)

    fun visitConst(expression: IrConst<*>, data: D): R = visitExpression(expression, data)

    fun visitConstantValue(expression: IrConstantValue, data: D): R = visitExpression(expression, data)

    fun visitConstantPrimitive(expression: IrConstantPrimitive, data: D): R = visitConstantValue(expression, data)

    fun visitConstantObject(expression: IrConstantObject, data: D): R = visitConstantValue(expression, data)

    fun visitConstantArray(expression: IrConstantArray, data: D): R = visitConstantValue(expression, data)

    fun visitDelegatingConstructorCall(expression: IrDelegatingConstructorCall, data: D): R = visitFunctionAccess(expression, data)

    fun visitDynamicExpression(expression: IrDynamicExpression, data: D): R = visitExpression(expression, data)

    fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression, data: D): R = visitDynamicExpression(expression, data)

    fun visitDynamicMemberExpression(expression: IrDynamicMemberExpression, data: D): R = visitDynamicExpression(expression, data)

    fun visitEnumConstructorCall(expression: IrEnumConstructorCall, data: D): R = visitFunctionAccess(expression, data)

    fun visitErrorExpression(expression: IrErrorExpression, data: D): R = visitExpression(expression, data)

    fun visitErrorCallExpression(expression: IrErrorCallExpression, data: D): R = visitErrorExpression(expression, data)

    fun visitFieldAccess(expression: IrFieldAccessExpression, data: D): R = visitDeclarationReference(expression, data)

    fun visitGetField(expression: IrGetField, data: D): R = visitFieldAccess(expression, data)

    fun visitSetField(expression: IrSetField, data: D): R = visitFieldAccess(expression, data)

    fun visitFunctionExpression(expression: IrFunctionExpression, data: D): R = visitExpression(expression, data)

    fun visitGetClass(expression: IrGetClass, data: D): R = visitExpression(expression, data)

    fun visitInstanceInitializerCall(expression: IrInstanceInitializerCall, data: D): R = visitExpression(expression, data)

    fun visitLoop(loop: IrLoop, data: D): R = visitExpression(loop, data)

    fun visitWhileLoop(loop: IrWhileLoop, data: D): R = visitLoop(loop, data)

    fun visitDoWhileLoop(loop: IrDoWhileLoop, data: D): R = visitLoop(loop, data)

    fun visitReturn(expression: IrReturn, data: D): R = visitExpression(expression, data)

    fun visitStringConcatenation(expression: IrStringConcatenation, data: D): R = visitExpression(expression, data)

    fun visitSuspensionPoint(expression: IrSuspensionPoint, data: D): R = visitExpression(expression, data)

    fun visitSuspendableExpression(expression: IrSuspendableExpression, data: D): R = visitExpression(expression, data)

    fun visitThrow(expression: IrThrow, data: D): R = visitExpression(expression, data)

    fun visitTry(aTry: IrTry, data: D): R = visitExpression(aTry, data)

    fun visitCatch(aCatch: IrCatch, data: D): R = visitElement(aCatch, data)

    fun visitTypeOperator(expression: IrTypeOperatorCall, data: D): R = visitExpression(expression, data)

    fun visitValueAccess(expression: IrValueAccessExpression, data: D): R = visitDeclarationReference(expression, data)

    fun visitGetValue(expression: IrGetValue, data: D): R = visitValueAccess(expression, data)

    fun visitSetValue(expression: IrSetValue, data: D): R = visitValueAccess(expression, data)

    fun visitVararg(expression: IrVararg, data: D): R = visitExpression(expression, data)

    fun visitSpreadElement(spread: IrSpreadElement, data: D): R = visitElement(spread, data)

    fun visitWhen(expression: IrWhen, data: D): R = visitExpression(expression, data)

    fun visitBranch(branch: IrBranch, data: D): R = visitElement(branch, data)

    fun visitElseBranch(branch: IrElseBranch, data: D): R = visitBranch(branch, data)
}
