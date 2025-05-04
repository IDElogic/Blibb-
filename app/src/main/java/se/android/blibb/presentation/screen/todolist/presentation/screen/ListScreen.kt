package se.android.blibb.presentation.screen.todolist.presentation.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import se.android.blibb.R
import se.android.blibb.presentation.screen.todolist.data.TodoItem
import se.android.blibb.presentation.screen.todolist.data.TodoPriority
import se.android.blibb.presentation.screen.todolist.presentation.util.SearchTopAppBar
import se.android.blibb.ui.theme.Black
import se.android.blibb.ui.theme.DIMENS_10dp
import se.android.blibb.ui.theme.DIMENS_20dp
import se.android.blibb.ui.theme.DIMENS_2dp
import se.android.blibb.ui.theme.DIMENS_32dp
import se.android.blibb.ui.theme.DIMENS_68dp
import se.android.blibb.ui.theme.DIMENS_90dp
import se.android.blibb.ui.theme.GilroyFontFamily
import se.android.blibb.ui.theme.MDark
import se.android.blibb.ui.theme.Ros
import se.android.blibb.ui.theme.TEXT_SIZE_10sp
import se.android.blibb.ui.theme.TEXT_SIZE_12sp
import se.android.blibb.ui.theme.TEXT_SIZE_16sp
import se.android.blibb.ui.theme.TEXT_SIZE_18sp
import se.android.blibb.ui.theme.TEXT_SIZE_1sp
import se.android.blibb.ui.theme.wheat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    todoListViewModel: TodoListViewModel = hiltViewModel(),
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()

    val sortOrder = todoListViewModel.getSortOrder().collectAsState(initial = SORTBY.CREATEDATE)

    val todoList by todoListViewModel.getAllToDoList(sortOrder.value).collectAsState(emptyList())

    var showAddDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var expanded by remember { mutableStateOf(false) }

    var todoToEdit: TodoItem? by rememberSaveable {
        mutableStateOf(null)
    }
    var searchText by rememberSaveable {
        mutableStateOf("")
    }
    var searchAppBarState by remember {
        mutableStateOf(false)
    }
    val wasStarted = todoListViewModel.getWasStarted().collectAsState(initial = true)

    var selectedBottomTab by remember { mutableIntStateOf(0) }

    var selectedPaidTab by remember { mutableIntStateOf(0) } // 0: Összes, 1: Fizetett, 2: Nem fizetett

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        containerColor =Black,
        topBar = {
            if (!searchAppBarState) {
                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = DIMENS_32dp)
                        .height(DIMENS_90dp)
                        .background( Black),
                    title = {
                    Row {
                        Column {
                            Spacer(
                                modifier = Modifier
                                    .height(8.dp)
                            )
                            Text(
                                text = "Titel",
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_18sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = TEXT_SIZE_1sp,
                                color = wheat.copy(0.66f),
                                modifier = Modifier
                                  //  .align(Alignment.CenterHorizontally)
                                    .padding(start = DIMENS_20dp)
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(2.dp)
                            )
                            Text(
                                text = "subtitle",
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_12sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = TEXT_SIZE_1sp,
                                color = wheat.copy(0.66f),
                                modifier = Modifier
                                 //   .align(Alignment.CenterHorizontally)
                                    .padding(start = DIMENS_20dp)
                            )}

                        Box (
                            modifier = Modifier
                                .padding(horizontal = DIMENS_68dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.bg_b),
                                contentDescription = "profile picture",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(80.dp, 80.dp)
                                    .clip(RoundedCornerShape(50.dp))
                            )
                        }}
                            },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Black/*MaterialTheme.colorScheme.surfaceVariant*/),
                    actions = {
                        IconButton(
                            modifier = Modifier
                                .padding(end = DIMENS_20dp),
                            onClick = { expanded = !expanded }
                        ) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = null,
                                tint = Ros
                            )
                        }
                        DropdownMenu(
                            containerColor = MenuDefaults.containerColor,
                            expanded = expanded,
                            onDismissRequest = { expanded = false }) {
                            DropdownMenuItem(onClick = {
                                coroutineScope.launch {
                                    if (sortOrder.value == SORTBY.TITLE) {
                                        todoListViewModel.storeSortOrder(SORTBY.CREATEDATE)
                                    } else {
                                        todoListViewModel.storeSortOrder(SORTBY.TITLE)
                                    }
                                }
                            }, text = {
                                if (sortOrder.value == SORTBY.TITLE) {
                                    Text(
                                        modifier = Modifier,
                                        color = Ros,
                                        text = "(*) Sort by title"
                                    )
                                } else {
                                    Text(text = "Sort by title")
                                }
                            })
                            DropdownMenuItem(
                                onClick = {
                                    coroutineScope.launch {
                                        if (sortOrder.value == SORTBY.DESCRIPTION) {
                                            todoListViewModel.storeSortOrder(SORTBY.CREATEDATE)
                                        } else {
                                            todoListViewModel.storeSortOrder(SORTBY.DESCRIPTION)
                                        }
                                    }
                                },
                                text = {
                                    if (sortOrder.value == SORTBY.DESCRIPTION) {
                                        Text(text = "(*) Sort by description")
                                    } else {
                                        Text(text = "Sort by description")
                                    }
                                })
                        }

                    })
            } else {
                SearchTopAppBar(
                    text = searchText,
                    onTextChange = { searchText = it },
                    onCloseClicked = {
                        searchAppBarState = false
                        searchText = ""
                    },
                    onSearchClicked = { it -> searchAppBarState = false })
            }
        },
        bottomBar = { // Helyezd ide a NavigationBar-t
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                containerColor = ( Black)
            ) {
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(Ros),
                    selected = selectedBottomTab == 0,
                    onClick = { selectedBottomTab = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Person",
                            tint = MDark
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedBottomTab == 1,
                    onClick = { selectedBottomTab = 1 },
                    icon = {
                        Icon(
                           imageVector = Icons.Default.Check,
                            contentDescription = "Done",
                            tint = MDark
                        )
                    }
                )
                IconButton(onClick = {
                    todoListViewModel.clearAllTodos()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = Ros
                    )
                }
                IconButton(
                    onClick = { searchAppBarState = true },
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Ros
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),
                containerColor = (Ros),
                onClick = {
                    showAddDialog = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = MDark,
                    contentDescription = null
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background( Black)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background( Black),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                if (showAddDialog) {
                    TodoForm(
                        onDialogClose = {
                            showAddDialog = false
                        },
                        todoListViewModel = todoListViewModel,
                        todoToEdit = todoToEdit
                    )
                }
                if (todoList.isEmpty())
                    Text(text = "No items")
                else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(Black)
                    ) {
                        items(todoList) {
                            TodoColumnItem(
                                searchText,
                                it,
                                selectedBottomTab,
                                selectedPaidTab, // Add selectedPaidTab here
                                todoListViewModel,
                                showAddDialog,
                                todoToEdit
                            )
                        }
                    }
                } }
                }
            }
        }
    )
}


@Composable
private fun TodoColumnItem(
    searchText: String,
    it: TodoItem,
    selectedBottomTab: Int,
    selectedPaidTab: Int,
    todoListViewModel: TodoListViewModel,
    showAddDialog: Boolean,
    todoToEdit: TodoItem?
) {
    var showAddDialog1 = showAddDialog
    var todoToEdit1 = todoToEdit
    if (searchText.isEmpty() || it.title.contains(searchText)) {
        val isDoneFiltered = when (selectedBottomTab) {
            0 -> true // Összes
            1 -> it.isDone // Csak a kész
            else -> !it.isDone // Csak a nem kész
        }

        // Az isPaid állapotot is figyelembe kell venni
        val isPaidFiltered = when (selectedPaidTab) {
            0 -> true // Összes
            1 -> it.isPaid // Csak a fizetett
            else -> !it.isPaid // Csak a nem fizetett
        }
        //   && it.isPaid
        if (isDoneFiltered && isPaidFiltered) {
            TodoCard(
                it,
                onRemoveItem = { todoListViewModel.removeTodoItem(it) },
                onTodoCheckChange = { checked ->
                    todoListViewModel.changeTodoState(
                        it,
                        checked
                    )
                },
                onEditItem = {
                    showAddDialog1 = true
                    todoToEdit1 = it
                },
                onTodoPaidChange = { paid -> // Az új callback
                    todoListViewModel.changeTodoPaidState(it, paid)
                }
            )
        }
    }
}

@Composable
fun TodoCard(
    todoItem: TodoItem,
    onTodoCheckChange: (Boolean) -> Unit = {},
    onRemoveItem: () -> Unit = {},
    onEditItem: (TodoItem) -> Unit = {},
    onTodoPaidChange: (Boolean) -> Unit = {},
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,

) {
    // -- background animation
    var expanded by rememberSaveable { mutableStateOf(false) }

    val animatedColor by animateColorAsState(
        if (expanded) Ros else Black,
        label = "color"
    )

    // -- longpress animation
    var showConfirmDialog by rememberSaveable { mutableStateOf(false) }
    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressed = mutableInteractionSource.collectIsPressedAsState()
    val elevation = animateDpAsState(
        targetValue = if (pressed.value) {
            42.dp
        } else {
            0.dp
        },
        finishedListener = {showConfirmDialog = true}, label = "showdeleteconfirm"
    )
    // --

    if (showConfirmDialog) {
        ConfirmDialog(
            content = "Do you wish to delet this?",
            onDismiss = { showConfirmDialog = false },
            onConfirm = {
                showConfirmDialog = false
                onRemoveItem()
            })
    }

    Box(
        modifier = Modifier
            .padding(horizontal = DIMENS_20dp, vertical = DIMENS_2dp)
            .clickable(interactionSource = mutableInteractionSource, indication = null) {}
            .graphicsLayer {
                this.shadowElevation = elevation.value.toPx()
            }
        ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(clipPath) {
                drawRoundRect(
                    color = MDark.copy(0.16f),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = MDark.copy(0.26f),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }
        var expanded by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .padding(0.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio =
                            Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .fillMaxSize()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .defaultMinSize(minHeight = 80.dp)
                    .fillMaxWidth(),
            ) {
                val (imgPriority, titleText, cbDone, iconDelete, iconEdit, iconExpanded, cbPaid) = createRefs()

                Text(
                    text = todoItem.title,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_16sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp,
                    modifier = Modifier
                        .constrainAs(titleText)
                        {
                            start.linkTo(parent.start, margin = 20.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        },
                    color = wheat.copy(0.86f)
                )
                Column(modifier = Modifier
                    .constrainAs(cbDone) {
                        end.linkTo(cbPaid.start, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)})
                    {
                Checkbox(
                    colors = CheckboxDefaults.colors(Ros),
                    checked = todoItem.isDone,
                    onCheckedChange = { onTodoCheckChange(it) },
                )
                        Text(
                            modifier = Modifier
                                .padding(vertical = DIMENS_2dp, horizontal = DIMENS_20dp),
                            color = wheat.copy(0.66f),
                            text = "a",
                            fontFamily = GilroyFontFamily,
                            fontSize = TEXT_SIZE_10sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = TEXT_SIZE_1sp
                        )
                }
                Column (
                    modifier = Modifier
                        .constrainAs(cbPaid) {
                            end.linkTo(iconDelete.start, margin = 10.dp)
                            bottom.linkTo(parent.bottom, margin = 10.dp)
                        }
                ){
                Checkbox(
                    colors = CheckboxDefaults.colors(MDark),
                    checked = todoItem.isPaid,
                    onCheckedChange = { onTodoPaidChange(it) },
                )
                    Text(
                        modifier = Modifier
                            .padding(vertical = DIMENS_2dp, horizontal = DIMENS_20dp),
                        color = wheat.copy(0.66f),
                        text = "b",
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_10sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp
                    )

                }
                
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onRemoveItem()
                        }
                        .constrainAs(iconDelete) {
                            end.linkTo(iconEdit.start, margin = 10.dp)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                        },
                    tint = Ros
                )
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onEditItem(todoItem)
                        }
                        .constrainAs(iconEdit) {
                            end.linkTo(iconExpanded.start, margin = 5.dp)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                        },
                    tint = Ros
                )
                IconButton(onClick = { expanded = !expanded },
                    modifier = Modifier
                        .constrainAs(iconExpanded) {
                            end.linkTo(parent.end, margin = 5.dp)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top) }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        imageVector = if (expanded) Icons.Filled.Close else Icons.Filled.ArrowDropDown,
                        contentDescription = if (expanded) {
                            "Less"
                        } else {
                            "More"
                        },
                        tint = Ros
                    )
                }
            }
            if (expanded) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = DIMENS_20dp),
                    color = wheat.copy(0.66f),
                    text = todoItem.description,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp
                )
                Text(
                    modifier = Modifier
                        .padding(DIMENS_20dp),
                    color = wheat.copy(0.66f),
                    text = todoItem.createDate,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp
                )
            }
        }
    }
}

@Composable
fun TodoForm(
    todoListViewModel: TodoListViewModel = viewModel(),
    onDialogClose: () -> Unit = {},
    todoToEdit: TodoItem? = null
) {
    var newTodoTitle by remember { mutableStateOf(todoToEdit?.title ?: "") }
    var newTodoDesc by remember { mutableStateOf(todoToEdit?.description ?: "") }
    var newTodoPriority by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDialogClose) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(size = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(wheat.copy(0.26f))
                    .fillMaxWidth()
                    .padding(DIMENS_10dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = DIMENS_10dp)
                ) {
                    OutlinedTextField(value = newTodoTitle,
                        modifier = Modifier.weight(1f),
                        label = {
                            Text(
                                text = "Titel:",
                                color = Black,
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_12sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = TEXT_SIZE_1sp
                            ) },
                        onValueChange = {
                            newTodoTitle = it
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(value = newTodoDesc,
                        modifier = Modifier.weight(1f),
                        label = {
                            Text(
                                text = "Description:",
                                color = Black,
                                fontFamily = GilroyFontFamily,
                                fontSize = TEXT_SIZE_12sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = TEXT_SIZE_1sp
                            ) },
                        onValueChange = {
                            newTodoDesc = it
                        }
                    )
                }


                Button(
                    modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(Ros),
                    onClick = {
                        if (todoToEdit == null) {
                            todoListViewModel.addTodoList(
                                TodoItem(
                                    title = newTodoTitle,
                                    description = newTodoDesc,
                                    createDate = Date(System.currentTimeMillis()).toString(),
                                    priority = if (newTodoPriority) TodoPriority.HIGH else TodoPriority.NORMAL,
                                    isDone = false
                                )
                            )
                        } else { // EDIT mode
                            var todoEdited = todoToEdit.copy(
                                title = newTodoTitle,
                                description = newTodoDesc,
                                priority = if (newTodoPriority) TodoPriority.HIGH else TodoPriority.NORMAL,
                            )

                            todoListViewModel.editTodoItem(todoToEdit, todoEdited)
                        }

                        onDialogClose()
                    },) {
                    Text(
                        text = "Save",
                        color = wheat,
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_12sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TEXT_SIZE_1sp
                    )
                }
            }
        }
    }
}


@Composable
fun ConfirmDialog(title: String? = null, content: String, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = {
            onDismiss()
        },
        text = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                if (!title.isNullOrEmpty()) {
                    Text(title,
                        modifier = Modifier.padding(vertical = 8.dp),
                        style = MaterialTheme.typography.titleMedium)
                }
                Text(content)
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismiss() })
            {
                Text(
                    text ="No",
                    color = wheat,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text(
                    text = "Yes",
                    color = wheat,
                    fontFamily = GilroyFontFamily,
                    fontSize = TEXT_SIZE_12sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TEXT_SIZE_1sp )
            }
        }
    )
}